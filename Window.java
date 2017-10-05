import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Window extends JFrame {

	private JPanel contentPane;
	private JSpinner beginDag;
	private JSpinner beginMaand;
	private JSpinner beginJaar;
	private JSpinner eindDag;
	private JSpinner eindMaand;
	private JSpinner eindJaar;
	private JSpinner gbDag;
	private JSpinner gbMaand;
	private JSpinner gbJaar;
	

	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBereken = new JButton("Bereken het Verschil");
		btnBereken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println(beginDag.getValue());
				Validate b = new Validate();
				Validate e = new Validate();
				Calculator c = new Calculator();
				
				boolean beginDate = false;
				boolean endDate = false;
				int bDag = (int) beginDag.getValue();
				String bMaand = (String) beginMaand.getValue();
				int bJaar = (int) beginJaar.getValue();
				b.setDay(bDag);
				b.setMonth(bMaand);
				b.setYear(bJaar);
				if(b.checkDate() == false){
					
					JOptionPane.showMessageDialog(null, "De begindatum die je hebt ingevoerd is niet juist, probeer het nog eens.", "Datum error", JOptionPane.ERROR_MESSAGE);
				}else{
					beginDate = true;
				}
				int eDag = (int) eindDag.getValue();
				String eMaand = (String) eindMaand.getValue();
				int eJaar = (int) eindJaar.getValue();
				e.setDay(eDag);
				e.setMonth(eMaand);
				e.setYear(eJaar);
				if(b.checkDate() == false){
					JOptionPane.showMessageDialog(null, "De einddatum die je hebt ingevoerd is niet juist, probeer het nog eens.", "Datum error", JOptionPane.ERROR_MESSAGE);
				}else{
					endDate = true;
				}
				if(beginDate == true &&endDate == true){
					
					int beginMonth = c.convertMonth((String)beginMaand.getValue());
					//System.out.println(beginMonth);
					int endMonth = c.convertMonth((String)eindMaand.getValue());
					//System.out.println(endMonth);
					long ms = c.differenceMiliseconds(b.getDay(), beginMonth, b.getYear(), e.getDay(), endMonth, e.getYear());
					long seconds = c.differenceSeconds(b.getDay(), beginMonth, b.getYear(), e.getDay(), endMonth, e.getYear());
					long hours = c.differenceHours(b.getDay(), beginMonth, b.getYear(), e.getDay(), endMonth, e.getYear());
					long days = c.differenceDays(b.getDay(), beginMonth, b.getYear(), e.getDay(), endMonth, e.getYear());
					long years = c.differenceYears(b.getYear(), e.getYear());
					JOptionPane.showMessageDialog(null, ms+" milisecondes "+seconds+" secondes "+hours+" Uren "+days+" Dagen "+years+" Jaren ", "Verschil", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBereken.setBounds(288, 177, 137, 25);
		contentPane.add(btnBereken);
		
		beginDag = new JSpinner();
		beginDag.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		beginDag.setBounds(8, 149, 41, 22);
		contentPane.add(beginDag);
		
		beginMaand = new JSpinner();
		beginMaand.setModel(new SpinnerListModel(new String[] {"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Julie", "Augustus", "September", "Oktober", "November", "December"}));
		beginMaand.setBounds(59, 149, 82, 22);
		contentPane.add(beginMaand);
		
		beginJaar = new JSpinner();
		beginJaar.setModel(new SpinnerNumberModel(2015, 1900, 2100, 1));
		beginJaar.setBounds(155, 149, 78, 22);
		contentPane.add(beginJaar);
		
		eindDag = new JSpinner();
		eindDag.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		eindDag.setBounds(8, 198, 41, 22);
		contentPane.add(eindDag);
		
		eindMaand = new JSpinner();
		eindMaand.setModel(new SpinnerListModel(new String[] {"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"}));
		eindMaand.setBounds(61, 198, 82, 22);
		contentPane.add(eindMaand);
		
		eindJaar = new JSpinner();
		eindJaar.setModel(new SpinnerNumberModel(2015, 1900, 2100, 1));
		eindJaar.setBounds(155, 198, 78, 22);
		contentPane.add(eindJaar);
		
		JLabel lblEinddatum = new JLabel("EindDatum");
		lblEinddatum.setBounds(8, 182, 82, 14);
		contentPane.add(lblEinddatum);
		
		JLabel lblBegindatum = new JLabel("BeginDatum");
		lblBegindatum.setBounds(8, 132, 82, 14);
		contentPane.add(lblBegindatum);
		
		gbDag = new JSpinner();
		gbDag.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		gbDag.setBounds(8, 60, 41, 20);
		contentPane.add(gbDag);
		
		gbMaand = new JSpinner();
		gbMaand.setModel(new SpinnerListModel(new String[] {"Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"}));
		gbMaand.setBounds(59, 60, 82, 20);
		contentPane.add(gbMaand);
		
		gbJaar = new JSpinner();
		gbJaar.setModel(new SpinnerNumberModel(2015, 1900, 2100, 1));
		gbJaar.setBounds(155, 60, 78, 20);
		contentPane.add(gbJaar);
		
		JLabel lblGeboortedatum = new JLabel("GeboorteDatum");
		lblGeboortedatum.setBounds(8, 43, 99, 14);
		contentPane.add(lblGeboortedatum);
		
		JButton btnBerekenJeLeeftijd = new JButton("Bereken je leeftijd");
		btnBerekenJeLeeftijd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Validate gb = new Validate();
				Calculator gbCalculate = new Calculator();
				
				boolean gbDate = false;
				int geboorteDag = (int) gbDag.getValue();
				String geboorteMaand = (String) gbMaand.getValue();
				int geboorteJaar = (int) gbJaar.getValue();
				gb.setDay(geboorteDag);
				gb.setMonth(geboorteMaand);
				gb.setYear(geboorteJaar);
				if(!gb.checkDate()){
					
					JOptionPane.showMessageDialog(null, "De geboortedatum die je hebt ingevoerd is niet juist, probeer het nog eens.", "Datum error", JOptionPane.ERROR_MESSAGE);
				}else{
					gbDate = true;
				}
				if(gbDate){
					int convertedGbMonth = gbCalculate.convertMonth(geboorteMaand);
					long ms = gbCalculate.aantalMs(geboorteDag, convertedGbMonth, geboorteJaar);
					long sec = gbCalculate.aantalSec(geboorteDag, convertedGbMonth, geboorteJaar);
					long hours = gbCalculate.aantalHours(geboorteDag, convertedGbMonth, geboorteJaar);
					long days = gbCalculate.aantalDays(geboorteDag, convertedGbMonth, geboorteJaar);
					long years = gbCalculate.aantalYears(geboorteDag, convertedGbMonth, geboorteJaar);
					
					JOptionPane.showMessageDialog(null, ms+" milisecondes "+sec+" secondes "+hours+" Uren "+days+" Dagen "+years+" Jaren ", "Leeftijd", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBerekenJeLeeftijd.setBounds(288, 59, 137, 23);
		contentPane.add(btnBerekenJeLeeftijd);
	}
}

package view;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Company;
import model.Order;
import javax.swing.border.MatteBorder;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import java.awt.FlowLayout;
import java.awt.Button;

public class View extends JFrame {

	private static Controller controller;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel defTable;
	private DefaultTableModel defaultDTable;
	private DefaultTableModel defaultOTable;
	private JTable table;
	private JTable detailsTable;
	private JTable OrderTable;
	private JTextField txtFormName;
	private JTextField txtFormStreet;
	private JTextField txtFormNumber;
	private JTextField txtFormPostal;
	private JTextField txtFormCity;
	private JTextField txtChoiceConnActive;

	private static final Object[] COLUMN_NAMES = { "ID", "Nazwa", "Ulica", "Numer", "Kod pocztowy", "Miasto" };
	private static final Object[] COLUMN_NAMES2 = { "Nr zamówienia", "Opis", "Ilość", "Cena" };
	private static final Object[] COLUMN_NAMES3 = { "Nr zamówienia", "ID Firmy", "Opis", "Ilość", "Cena" };
	private JTextField txtDetailsName;
	private JTextField txtDetailsStreet;
	private JTextField txtDetailsNumber;
	private JTextField txtDetailsCity;
	private JTextField txtDetailsPostal;
	private JTextField txtDetailsID;
	private JTextField txtDetailsAddODesc;
	private JTextField txtDetailsAddOPrice;
	private JTextField txtDetailsAddOQuant;
	private JTextField txtDetailsAddOFor;
	private JTextField txtEditODesc;
	private JTextField txtEditOQuant;
	private JTextField txtEditOPrice;
		
	
	public View() {		
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));		
		contentPane.add(tabbedPane, "name_170854389960070");

		// ----------------------------- Company Pane -------------------
		JPanel CompPanel = new JPanel();
		Panel CompanyForm = new Panel();
		JLabel lblNazwa = new JLabel("Nazwa:");
		JLabel lblUlica = new JLabel("Ulica:");
		JLabel lblKodPocztowy = new JLabel("Miasto:");		
		JLabel lblNumer = new JLabel("Numer:");
		JLabel lblMiasto = new JLabel("Kod pocztowy:");		
		JPanel OrderPanel = new JPanel();
		JScrollPane OrderScrollPane = new JScrollPane();
		JLabel lblAllOrders = new JLabel("Lista wszystkich zamówień");
		JButton btnOrderPanelDelete = new JButton("Usuń");
		JPanel DetailsPanel = new JPanel();
		Panel AddOrderPanel = new Panel();
		JSeparator separator = new JSeparator();
		JLabel lblFirma = new JLabel("Firma:");
		JLabel lblUlica_1 = new JLabel("Ulica:");
		JLabel lblMiasto_1 = new JLabel("Miasto:");
		JScrollPane DetailsScrollPane = new JScrollPane();
		JLabel lblNr = new JLabel("Nr:");
		JLabel lblKod = new JLabel("kod:");
		JLabel lblDetailsID = new JLabel("ID:");
		JPanel AddOrder = new JPanel();
		JLabel lblAddOrderFor = new JLabel("Zamówienie dla: ");
		JLabel lblAddOrderPrice = new JLabel("cena:");
		JLabel lblAddOrderQuant = new JLabel("ilość:");
		JLabel lblAddOrderDesc = new JLabel("Opis:");
		JPanel EditOrder = new JPanel();
		JLabel lblOpis = new JLabel("Opis:");
		JLabel lblNewLabel = new JLabel("ilość:");
		JLabel lblNewLabel_1 = new JLabel("cena:");
		JButton btnDodajFirme = new JButton("Dodaj firme");
		
		tabbedPane.addTab("Firmy", null, CompPanel, "");
		CompPanel.setLayout(null);
		defTable = new DefaultTableModel(COLUMN_NAMES, 0);
		defaultDTable = new DefaultTableModel(COLUMN_NAMES2, 0);
		defaultOTable = new DefaultTableModel(COLUMN_NAMES3, 0);
		
		CompanyForm.setBounds(389, 0, 555, 298);
		CompPanel.add(CompanyForm);
		CompanyForm.setName("companyNewForm");
		CompanyForm.setVisible(false);
		CompanyForm.setLayout(null);		
		lblNazwa.setBounds(12, 33, 72, 26);
		CompanyForm.add(lblNazwa);		
		lblUlica.setBounds(12, 72, 56, 16);
		CompanyForm.add(lblUlica);		
		lblNumer.setBounds(12, 101, 56, 16);
		CompanyForm.add(lblNumer);		
		lblKodPocztowy.setBounds(12, 131, 84, 16);
		CompanyForm.add(lblKodPocztowy);		
		lblMiasto.setBounds(12, 160, 84, 16);
		CompanyForm.add(lblMiasto);
		txtFormName = new JTextField();
		txtFormName.setBounds(106, 35, 373, 22);
		CompanyForm.add(txtFormName);
		txtFormName.setColumns(10);
		txtFormStreet = new JTextField();
		txtFormStreet.setBounds(106, 65, 310, 22);
		CompanyForm.add(txtFormStreet);
		txtFormStreet.setColumns(10);
		txtFormNumber = new JTextField();
		txtFormNumber.setBounds(106, 98, 72, 22);
		CompanyForm.add(txtFormNumber);
		txtFormNumber.setColumns(10);
		txtFormPostal = new JTextField();
		txtFormPostal.setBounds(106, 128, 310, 22);
		CompanyForm.add(txtFormPostal);
		txtFormPostal.setColumns(10);
		txtFormCity = new JTextField();
		txtFormCity.setBounds(106, 157, 72, 22);
		CompanyForm.add(txtFormCity);
		txtFormCity.setColumns(10);

		// ---------------- ORDER PANE -------------
		tabbedPane.addTab("Zamówienia", null, OrderPanel, null);
		OrderPanel.setLayout(null);		
		OrderScrollPane.setBounds(12, 91, 1027, 462);
		OrderPanel.add(OrderScrollPane);
		OrderTable = new JTable(defaultOTable);
		OrderScrollPane.setViewportView(OrderTable);		
		lblAllOrders.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAllOrders.setBounds(12, 42, 351, 36);
		OrderPanel.add(lblAllOrders);		
		btnOrderPanelDelete.setBounds(871, 42, 77, 25);
		btnOrderPanelDelete.setEnabled(false);
		OrderPanel.add(btnOrderPanelDelete);
		
		// Order Table Listener - enables delete button
		OrderTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int row = OrderTable.getSelectedRow();
				if (row >= 0) {
					btnOrderPanelDelete.setEnabled(true);
				}
			}
		});
		
		// Delete Order Button - actually removes data from DB
		btnOrderPanelDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = OrderTable.getSelectedRow();
				int orderID = (Integer) OrderTable.getValueAt(row, 0);
				int companyOrderID = (Integer) OrderTable.getValueAt(row, 1);
				controller.deleteOrder(orderID);
				controller.refreshOrdersList();
				controller.getSpecOrders(companyOrderID);
			}
		});		
		
		// ---------------- DETAILS PANE ------------
		DetailsPanel.setBorder(null);
		tabbedPane.addTab("Szczegóły", null, DetailsPanel, null);
		tabbedPane.setEnabledAt(2, false);
		DetailsPanel.setLayout(null);		
		AddOrderPanel.setBounds(210, 216, 659, 195);
		DetailsPanel.add(AddOrderPanel);
		AddOrderPanel.setVisible(false);
		AddOrderPanel.setLayout(new CardLayout(0, 0));		
		separator.setFont(new Font("Dialog", Font.PLAIN, 16));
		separator.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Zam\u00F3wienia",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		separator.setBounds(875, 145, 165, 217);
		DetailsPanel.add(separator);
		txtDetailsName = new JTextField();
		txtDetailsName.setEditable(false);
		txtDetailsName.setMargin(new Insets(2, 16, 2, 2));
		txtDetailsName.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDetailsName.setBorder(null);
		txtDetailsName.setBackground(SystemColor.controlHighlight);
		txtDetailsName.setBounds(116, 13, 600, 31);
		DetailsPanel.add(txtDetailsName);
		txtDetailsName.setColumns(10);
		txtDetailsStreet = new JTextField();
		txtDetailsStreet.setMargin(new Insets(2, 15, 2, 2));
		txtDetailsStreet.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDetailsStreet.setEditable(false);
		txtDetailsStreet.setBorder(null);
		txtDetailsStreet.setBackground(SystemColor.controlHighlight);
		txtDetailsStreet.setBounds(116, 57, 241, 22);
		DetailsPanel.add(txtDetailsStreet);
		txtDetailsStreet.setColumns(10);
		txtDetailsNumber = new JTextField();
		txtDetailsNumber.setMargin(new Insets(2, 15, 2, 2));
		txtDetailsNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDetailsNumber.setEditable(false);
		txtDetailsNumber.setBorder(null);
		txtDetailsNumber.setBackground(SystemColor.controlHighlight);
		txtDetailsNumber.setBounds(437, 57, 46, 22);
		DetailsPanel.add(txtDetailsNumber);
		txtDetailsNumber.setColumns(10);
		txtDetailsCity = new JTextField();
		txtDetailsCity.setMargin(new Insets(2, 15, 2, 2));
		txtDetailsCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDetailsCity.setEditable(false);
		txtDetailsCity.setBorder(null);
		txtDetailsCity.setBackground(SystemColor.controlHighlight);
		txtDetailsCity.setBounds(116, 92, 241, 22);
		DetailsPanel.add(txtDetailsCity);
		txtDetailsCity.setColumns(10);
		txtDetailsPostal = new JTextField();
		txtDetailsPostal.setMargin(new Insets(2, 15, 2, 2));
		txtDetailsPostal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDetailsPostal.setEditable(false);
		txtDetailsPostal.setBorder(null);
		txtDetailsPostal.setBackground(SystemColor.controlHighlight);
		txtDetailsPostal.setBounds(415, 92, 68, 22);
		DetailsPanel.add(txtDetailsPostal);
		txtDetailsPostal.setColumns(10);		
		lblFirma.setBounds(48, 20, 56, 16);
		DetailsPanel.add(lblFirma);		
		lblUlica_1.setBounds(48, 60, 56, 16);
		DetailsPanel.add(lblUlica_1);	
		lblMiasto_1.setBounds(48, 95, 56, 16);
		DetailsPanel.add(lblMiasto_1);		
		DetailsScrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DetailsScrollPane.setBounds(12, 145, 850, 408);
		DetailsPanel.add(DetailsScrollPane);


		detailsTable = new JTable(defaultDTable);
		detailsTable.setRowHeight(19);
		detailsTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DetailsScrollPane.setViewportView(detailsTable);		
		lblNr.setBounds(407, 61, 18, 16);
		DetailsPanel.add(lblNr);		
		lblKod.setBounds(378, 96, 25, 16);
		DetailsPanel.add(lblKod);
		txtDetailsID = new JTextField();
		txtDetailsID.setName("id");
		txtDetailsID.setBackground(SystemColor.controlHighlight);
		txtDetailsID.setBorder(null);
		txtDetailsID.setEditable(false);
		txtDetailsID.setBounds(837, 20, 25, 22);
		DetailsPanel.add(txtDetailsID);
		txtDetailsID.setColumns(10);	
		lblDetailsID.setBounds(807, 23, 18, 16);
		DetailsPanel.add(lblDetailsID);

		// Add/Edit Order Pane		
		AddOrder.setVisible(false);
		AddOrderPanel.add(AddOrder, "name_164377345864327");
		AddOrder.setLayout(null);
		txtDetailsAddODesc = new JTextField();
		txtDetailsAddODesc.setBounds(74, 60, 361, 22);
		AddOrder.add(txtDetailsAddODesc);
		txtDetailsAddODesc.setColumns(10);
		txtDetailsAddOFor = new JTextField();
		txtDetailsAddOFor.setBounds(162, 13, 284, 30);
		AddOrder.add(txtDetailsAddOFor);
		txtDetailsAddOFor.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDetailsAddOFor.setBorder(null);
		txtDetailsAddOFor.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		txtDetailsAddOFor.setEditable(false);
		txtDetailsAddOFor.setColumns(10);		
		lblAddOrderFor.setBounds(20, 14, 146, 22);
		AddOrder.add(lblAddOrderFor);
		lblAddOrderFor.setFont(new Font("Tahoma", Font.PLAIN, 17));		
		lblAddOrderPrice.setBounds(131, 137, 35, 16);
		AddOrder.add(lblAddOrderPrice);		
		lblAddOrderQuant.setBounds(131, 95, 35, 22);
		AddOrder.add(lblAddOrderQuant);		
		lblAddOrderDesc.setBounds(30, 60, 51, 22);
		AddOrder.add(lblAddOrderDesc);
		txtDetailsAddOQuant = new JTextField();
		txtDetailsAddOQuant.setBounds(170, 95, 92, 22);
		AddOrder.add(txtDetailsAddOQuant);
		txtDetailsAddOQuant.setColumns(10);
		txtDetailsAddOPrice = new JTextField();
		txtDetailsAddOPrice.setBounds(170, 134, 92, 22);
		AddOrder.add(txtDetailsAddOPrice);
		txtDetailsAddOPrice.setColumns(10);		
		EditOrder.setVisible(false);
		AddOrderPanel.add(EditOrder, "name_165001694624925");
		EditOrder.setLayout(null);
		txtEditODesc = new JTextField();
		txtEditODesc.setBounds(79, 29, 514, 22);
		EditOrder.add(txtEditODesc);
		txtEditODesc.setColumns(10);		
		lblOpis.setBounds(29, 32, 38, 16);
		EditOrder.add(lblOpis);
		txtEditOQuant = new JTextField();
		txtEditOQuant.setBounds(155, 75, 99, 22);
		EditOrder.add(txtEditOQuant);
		txtEditOQuant.setColumns(10);
		txtEditOPrice = new JTextField();
		txtEditOPrice.setBounds(155, 110, 99, 22);
		EditOrder.add(txtEditOPrice);
		txtEditOPrice.setColumns(10);		
		lblNewLabel.setBounds(105, 78, 38, 16);
		EditOrder.add(lblNewLabel);		
		lblNewLabel_1.setBounds(105, 113, 38, 16);
		EditOrder.add(lblNewLabel_1);
		
		// New Company Button
		btnDodajFirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompanyForm.setVisible(true);
			}
		});

		// Company Form OK Button - actually creating new Company
		JButton btnFormOk = new JButton("OK");
		btnFormOk.setBounds(96, 229, 97, 25);
		CompanyForm.add(btnFormOk);
		btnFormOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Company company = new Company(txtFormName.getText(),
												txtFormStreet.getText(),
												Integer.parseInt(txtFormNumber.getText()),
												txtFormPostal.getText(),
												txtFormCity.getText());
				controller.insertObject(company);

				for (Component text : CompanyForm.getComponents()) {
					if (text instanceof JTextField) {
						((JTextField) text).setText("");
					}
				}
				CompanyForm.setVisible(false);
			}
		});

		JButton btnFormCancel = new JButton("Anuluj");
		btnFormCancel.setBounds(295, 229, 97, 25);
		CompanyForm.add(btnFormCancel);
		btnDodajFirme.setBounds(12, 23, 108, 25);
		CompPanel.add(btnDodajFirme);
		
		// New Company Form Cancel Button
		btnFormCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompanyForm.setVisible(false);
				for (Component text : CompanyForm.getComponents()) {
					if (text instanceof JTextField) {
						((JTextField) text).setText("");
					}
				}
			}
		});

		JButton btnUsuFirme = new JButton("Usuń firme");
		btnUsuFirme.setBounds(132, 23, 97, 25);
		CompPanel.add(btnUsuFirme);
		
		// Delete Company Button
		btnUsuFirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				int companyID = (Integer) table.getValueAt(row, 0);
				if (row >= 0) {
					controller.deleteCompany(companyID);
				}
			}
		});

		JButton btnSzczegoly = new JButton("Szczegóły");
		btnSzczegoly.setBounds(241, 23, 97, 25);
		CompPanel.add(btnSzczegoly);
		
		// Company Details Button
		btnSzczegoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Component component = tabbedPane.getComponent(2);
				if ((component.isEnabled()) & (table.getSelectedRow() >= 0)) {
					tabbedPane.setSelectedIndex(2);
				} else {
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setPreferredSize(new Dimension(2, 15));
		scrollPane.setBounds(12, 68, 1027, 485);
		CompPanel.add(scrollPane);

		table = new JTable(defTable);
		table.setFocusable(false);
		table.setVerifyInputWhenFocusTarget(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 20));
		table.setRowHeight(23);
		table.setAutoCreateRowSorter(true);

		// CompanyPane List Listener
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					tabbedPane.setEnabledAt(2, true);
					int numb = (Integer) table.getValueAt(row, 3);
					String postal = (String) table.getValueAt(row, 4);
					txtDetailsID.setText(Integer.toString((Integer) table.getValueAt(row, 0)));
					txtDetailsName.setText((String) table.getValueAt(row, 1));
					txtDetailsStreet.setText((String) table.getValueAt(row, 2));
					txtDetailsNumber.setText(Integer.toString(numb));
					txtDetailsCity.setText((String) table.getValueAt(row, 5));
					txtDetailsPostal.setText(postal);

					controller.getSpecOrders((Integer) table.getValueAt(row, 0));

				} else {
					tabbedPane.setEnabledAt(2, false);
				}
			}
		});

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		detailsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		OrderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Details Panel
		JButton btnDetailsEditOK = new JButton("Zatwierdz");
		btnDetailsEditOK.setVisible(false);
		btnDetailsEditOK.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		btnDetailsEditOK.setBounds(662, 92, 97, 25);
		DetailsPanel.add(btnDetailsEditOK);

		JButton btnDetailsEditC = new JButton("Edytuj");
		btnDetailsEditC.setBounds(553, 93, 97, 25);
		DetailsPanel.add(btnDetailsEditC);
		
		// Edit Company Button in Details Pane
		btnDetailsEditC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component text : DetailsPanel.getComponents()) {
					if ((text instanceof JTextField) & (text.getName() != "id")) {
						((JTextField) text).setEditable(true);
						((JTextField) text).setBorder(new LineBorder(new Color(255, 200, 0), 2));
					}
				}
				btnDetailsEditOK.setVisible(true);
				btnDetailsEditC.setEnabled(false);
			}
		});

		// Confirm Editing Company Button in Details Pane
		btnDetailsEditOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Company company = new Company(Integer.parseInt(txtDetailsID.getText()), txtDetailsName.getText(),
						txtDetailsStreet.getText(), Integer.parseInt(txtDetailsNumber.getText()),
						 txtDetailsPostal.getText(), txtDetailsCity.getText());
				controller.updateObject(company);

				for (Component text : DetailsPanel.getComponents()) {
					if ((text instanceof JTextField) & (text.getName() != "id")) {
						((JTextField) text).setEditable(false);
						((JTextField) text).setBorder(null);
					}
				}
				btnDetailsEditOK.setVisible(false);
				btnDetailsEditC.setEnabled(true);
				controller.refreshCompanyList();
				tabbedPane.setEnabledAt(2, true);

			}
		});

		JButton btnDetailsAddO = new JButton("Dodaj");
		btnDetailsAddO.setBounds(904, 202, 97, 25);
		DetailsPanel.add(btnDetailsAddO);
		
		// New Order Button in Details Pane
		btnDetailsAddO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddOrderPanel.setVisible(true);
				txtDetailsAddOFor.setText(txtDetailsName.getText());

			}
		});

		JButton btnDetailsDeleteO = new JButton("Usuń");
		JButton btnDetailsEditO = new JButton("Edytuj");
		btnDetailsDeleteO.setBounds(904, 258, 97, 25);
		DetailsPanel.add(btnDetailsDeleteO);
		btnDetailsDeleteO.setEnabled(false);
		
		// Delete Order Button in Details Pane - actually deletes data from DB
		btnDetailsDeleteO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = detailsTable.getSelectedRow();
				if (row >= 0) {

					int companyID = Integer.parseInt(txtDetailsID.getText());
					int id = (Integer) detailsTable.getValueAt(row, 0);
					controller.deleteOrder(id);
					controller.getSpecOrders(companyID);
					controller.refreshOrdersList();
					btnDetailsDeleteO.setEnabled(false);
					btnDetailsEditO.setEnabled(false);
				} else {					
				}
			}
		});		
		btnDetailsEditO.setBounds(904, 312, 97, 25);
		DetailsPanel.add(btnDetailsEditO);
		btnDetailsEditO.setEnabled(false);
		
		// Edit Order Button in Details Pane
		btnDetailsEditO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = detailsTable.getSelectedRow();
				if (row >= 0) {					
					AddOrder.setVisible(false);
					AddOrderPanel.setVisible(true);
					EditOrder.setVisible(true);

					String quant = detailsTable.getValueAt(row, 2).toString();
					String price = detailsTable.getValueAt(row, 3).toString();
					txtEditODesc.setText(detailsTable.getValueAt(row, 1).toString());
					txtEditOQuant.setText(quant);
					txtEditOPrice.setText(price);
				} else {
				}
			}
		});

		JButton btnDetailsAddOOK = new JButton("OK");
		btnDetailsAddOOK.setBounds(540, 160, 92, 22);
		AddOrder.add(btnDetailsAddOOK);

		JButton btnDetailsAddOCancel = new JButton("Anuluj");
		btnDetailsAddOCancel.setBounds(409, 160, 92, 22);
		AddOrder.add(btnDetailsAddOCancel);

		// Details Pane Table Listener - unlocks Edit and Delete order buttons
		detailsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int row = detailsTable.getSelectedRow();
				if (row >=0) {
					btnDetailsEditO.setEnabled(true);
					btnDetailsDeleteO.setEnabled(true);
				} else {
					btnDetailsEditO.setEnabled(false);
					btnDetailsDeleteO.setEnabled(false);
				}
			}
		});
		
		
		// Edit Order Pane

		JButton btnEditOOK = new JButton("Zatwierdz");
		btnEditOOK.setBounds(531, 145, 97, 25);
		EditOrder.add(btnEditOOK);
		
		// Edit Order confirmation button - actually saves new data in DB
		btnEditOOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = detailsTable.getSelectedRow();
				Order order = new Order((Integer) detailsTable.getValueAt(row, 0), Integer.parseInt(txtDetailsID.getText()),
						txtEditODesc.getText(), Integer.parseInt(txtEditOQuant.getText()),
						Float.parseFloat(txtEditOPrice.getText()));
				controller.updateObject(order);
				controller.getSpecOrders(Integer.parseInt(txtDetailsID.getText()));
				controller.refreshOrdersList();

				EditOrder.setVisible(false);
				AddOrderPanel.setVisible(false);
				btnDetailsEditO.setEnabled(false);
				btnDetailsDeleteO.setEnabled(false);

			}
		});

		JButton btnEditOCancel = new JButton("Anuluj");
		btnEditOCancel.setBounds(369, 145, 97, 25);
		EditOrder.add(btnEditOCancel);
		
		// Edit Order cancel button
		btnEditOCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditOrder.setVisible(false);
				AddOrderPanel.setVisible(false);
			}
		});
		
		// New Order cancel button
		btnDetailsAddOCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddOrderPanel.setVisible(false);
			}
		});
		
		// New Order confirmation button - actually saves data in DB
		btnDetailsAddOOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order order = new Order(Integer.parseInt(txtDetailsID.getText()), txtDetailsAddODesc.getText(),
						Integer.parseInt(txtDetailsAddOQuant.getText()),
						Float.parseFloat(txtDetailsAddOPrice.getText()));
				controller.insertObject(order);
				AddOrderPanel.setVisible(false);

				for (Component text : AddOrder.getComponents()) {
					if (text instanceof JTextField) {
						((JTextField) text).setText("");
					}
				}
				controller.getSpecOrders(Integer.parseInt(txtDetailsID.getText()));
			}
		});

		// Option Panel ############

		JPanel OptionPanel = new JPanel();
		tabbedPane.addTab("Opcje", null, OptionPanel, "");
		tabbedPane.setSelectedIndex(3);

		Choice txtDatabaseChoice = new Choice();
		txtDatabaseChoice.setBounds(72, 76, 246, 22);
		txtDatabaseChoice.add("SQLite");
		txtDatabaseChoice.add("MySQL");
		txtDatabaseChoice.add("PostgreSQL");
		OptionPanel.setLayout(null);
		OptionPanel.add(txtDatabaseChoice);

		
		// CHOOSE DB
		
		JLabel lblDBChoice = new JLabel("Wybierz baze danych");
		lblDBChoice.setBounds(72, 48, 217, 22);
		lblDBChoice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OptionPanel.add(lblDBChoice);

		JButton btnChoiceConn = new JButton("Połącz");
		
		// Connect Button in Options Pane
		btnChoiceConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choice = txtDatabaseChoice.getSelectedIndex();
				
				if (controller.connectToDB(choice)) {					
					txtChoiceConnActive.setBackground(Color.GREEN);
					txtChoiceConnActive.setText(txtDatabaseChoice.getSelectedItem());
				} else {
					txtChoiceConnActive.setBackground(Color.RED);
					txtChoiceConnActive.setText("Błąd połączenia");
				}
			}
		});
		btnChoiceConn.setBounds(373, 73, 97, 25);
		OptionPanel.add(btnChoiceConn);

		txtChoiceConnActive = new JTextField();
		txtChoiceConnActive.setHorizontalAlignment(SwingConstants.CENTER);
		txtChoiceConnActive.setForeground(Color.BLACK);
		txtChoiceConnActive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChoiceConnActive.setBounds(72, 121, 246, 22);
		txtChoiceConnActive.setBorder(null);
		txtChoiceConnActive.setEditable(false);
		txtChoiceConnActive.setBackground(Color.ORANGE);
		OptionPanel.add(txtChoiceConnActive);
		txtChoiceConnActive.setColumns(10);
		// OptionPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{databaseChoice, lblDBChoice, btnChoiceOK, btnChoiceConn,
		// txtChoiceConnActive}));
		// tabbedPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{CompPanel, CompanyForm, txtFormName, lblNazwa, lblUlica,
		// lblNumer, lblKodPocztowy, lblMiasto, txtFormStreet, txtFormNumber,
		// txtFormPostal, txtFormCity, btnFormOk, btnFormCancel, table, btnDodajFirme,
		// btnUsuFirme, btnSzczegy, panel_1, OptionPanel, databaseChoice, lblDBChoice,
		// btnChoiceOK, btnChoiceConn, txtChoiceConnActive}));
	}

	public void setController(Controller controller) {
		View.controller = controller;
	}

	public void getCompanies(List<Company> companies) {
		if (companies.size() > 0) {
			defTable.getDataVector().clear();
			for (Company company : companies) {
				defTable.addRow(new Object[] { company.getID(), company.getName(), company.getStreet(),
						company.getNumber(), company.getPostal(), company.getCity() });
			}
		} else {
			defTable.setRowCount(0);
		}
	}

	public void getOrders(List<Order> orders) {
		if (orders.size() > 0) {
			defaultOTable.getDataVector().clear();
			for (Order order : orders) {
				defaultOTable.addRow(new Object[] { order.getId(), order.getCompanyID(), order.getDescription(),
						order.getQuantity(), order.getPrice() });
			}
		} else {
			defaultOTable.setRowCount(0);
		}
	}

	public void getSpecOrders(List<Order> orders) {
		if (orders.size() > 0) {
			defaultDTable.getDataVector().clear();
			for (Order order : orders) {
				defaultDTable.addRow(
						new Object[] { order.getId(), order.getDescription(), order.getQuantity(), order.getPrice() });
			}
		} else {
			defaultDTable.setRowCount(0);
		}
	}
}

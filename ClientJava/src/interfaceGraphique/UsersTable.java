package interfaceGraphique;



import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dao.UserRepository;
import exception.WebServiceException;
import service.*;

public class UsersTable {
    private static UserRepository userRepo;
    JLabel title = new JLabel("List Of Users !");
    public UsersTable(CenterPanel p) {
        title.setBounds(50, 10, 250, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 25));

         try {
            userRepo = UserRepository.getUserRepoInstance();
        } catch (WebServiceException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public JTable getUsersTable(CenterPanel p,String query) {
        JTable table = new JTable();
        try {
            List<User> users=null;
            if (query.equals("")) {   
                GetUsersResponse response = userRepo.getUsers(new GetUsers());
                users = response.getReturn();
            }
            String titles[] = new String[] { "Id", "Login","Role"};
            DefaultTableModel tableModel = new DefaultTableModel(0, 0)
            {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 7;
                }
            };
            tableModel.setColumnIdentifiers(titles);
            for (User user : users) {
                Object[] objs = { user.getId(), user.getEmail(), user.getRole()};
                    tableModel.addRow(objs);
            }
            table.setModel(tableModel);
            table.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int symbol =  (int) table.getModel().getValueAt(table.rowAtPoint(e.getPoint()), 0);
                        p.displayAlterUserForm(symbol);
                    }
                }
                @Override
                public void mousePressed(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {} 
            });
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.setFont(new Font(null,Font.BOLD,15));
            tableHeader.setForeground(Color.BLACK);
            tableHeader.setBackground(Color.LIGHT_GRAY);
            tableHeader.setOpaque(false);
            table.setRowHeight(25);
            table.setFillsViewportHeight(true); 
            table.setFont(new Font(null, Font.ROMAN_BASELINE, 15));
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(10);
            columnModel.getColumn(1).setPreferredWidth(150);
            columnModel.getColumn(2).setPreferredWidth(100);
            columnModel.getColumn(3).setPreferredWidth(100);
            columnModel.getColumn(4).setPreferredWidth(100);
            columnModel.getColumn(5).setPreferredWidth(100);
            columnModel.getColumn(6).setPreferredWidth(50);
        } catch (Exception e) {}
        return table;
    }
}
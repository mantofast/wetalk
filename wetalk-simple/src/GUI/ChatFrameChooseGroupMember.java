package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.List;

import javax.swing.JLayeredPane;
import javax.swing.JScrollBar;
import javax.swing.JTree;

import message.GroupChatMessage;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ChatFrameChooseGroupMember extends JFrame {
	protected static Logger log = 
			LoggerFactory.getLogger(ChatFrameChooseGroupMember.class);
	
	
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ChatFrameChooseGroupMember() {
		setTitle("选择群组成员");
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 131, 198);
		layeredPane.add(scrollPane);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		tree.setToolTipText("");
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(313, 215, 93, 23);
		layeredPane.add(btnNewButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(230, 10, 154, 191);
		layeredPane.add(scrollPane_2);
		
		textField = new JTextField();
		scrollPane_2.setViewportView(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("》");
		btnNewButton_1.setBounds(162, 53, 45, 23);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("《");
		btnNewButton_2.setBounds(162, 105, 45, 23);
		layeredPane.add(btnNewButton_2);
		
	}
	public static void showFrameChoose(){
		try {
			ChatFrameChooseGroupMember frame = new ChatFrameChooseGroupMember();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

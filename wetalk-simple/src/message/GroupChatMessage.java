package message;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import usermanager.User;

public class GroupChatMessage implements java.io.Serializable{
	public static final byte BUILD_GROUP_MESSAGE = 0x01;		//broadcast
	public static final byte JION_GROUP_MESSAGE = 0x02;		    //unicast
	
	private byte type;
	private List<User> UserList;//群聊用户列表
	private int port;//群聊监听端口号
	private String GroupName;
	
	public  GroupChatMessage(byte msgtype,int port,String GroupName){
		this.type = msgtype;
		this.port=port;
		this.GroupName=GroupName;
	}
	
	public byte getType(){
		return type;
	}
	
	public void setUser(List<User> UserList){
		this.UserList =  UserList;
	}
	
	public List<User> getUserList(){
		return UserList;
	}
	
	
	
	
	@SuppressWarnings("finally")
	public byte[] srialize(){
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		byte msg[] = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(this);	//顶层输入
			oos.flush();
		    msg = baos.toByteArray();	//底层输出
		} catch (IOException e) {

		} finally{
			return msg;			
		}
				
	}
	@SuppressWarnings("finally")
	public static GroupChatMessage deserialize(byte[] in){
		ByteArrayInputStream bais = new ByteArrayInputStream(in);
		ObjectInputStream ois;
		GroupChatMessage msg = null;
		try {
			ois = new ObjectInputStream(bais);
			msg = (GroupChatMessage)ois.readObject();	
			return msg;			
		} catch (Exception e) {

		} finally {
			return msg; 
		}


	}
	

	
}

	
	
	
	



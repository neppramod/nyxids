package nyxmain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import java.util.*;
import java.text.*;

import javax.swing.event.*;
import javax.swing.table.TableModel;
import java.util.regex.*;
import util.*;



import jade.wrapper.*;
import jade.core.*;
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import java.util.Vector;

import jade.core.*;





public class MainGui {

	private static String MOVELABEL = "Start";
	private static String REFRESHLABEL = "Refresh Locations";
	private static String STOPLABEL="Stop";
	private LocationTableModel availableSiteListModel;
	private JTable availableSiteList;
	JFrame frame;
	TableDemo newContentPane;
	//Boolean[][] rule;
	
	
	
	
	
	///////////////from Agent Generator////////////
	//Location newLoc;
	ContainerController cc;
	AgentController ac0;
	AgentController ac1;
	AgentController[] sensorController=new AgentController[1000];
	AgentController[] responseController=new AgentController[1000];
	AgentController proxyController;
	
	int sensorCounter=0;
	int responseCounter=0;
	Location[] agentLocation=new Location[1000];
	MainGui mg;
	int cnt=1000;
	/////////////////////////////////////////////////
	
	public static void main(String[] args){
		
		
		
		MainGui mainGui=new MainGui();
		
		
		
		mainGui.setup(mainGui);
		
		mainGui.frame=new JFrame();
		
		mainGui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGui.frame.setResizable(false);
		
		
		
		Panel1 panel1=new Panel1();
		mainGui.frame.getContentPane().add(panel1);
		
		//mainGui.rule=new Boolean[20][100];
		//for(int i=0;i<20;i++){
			
		//	for(int j=0;j<100;j++){
				
		//		mainGui.rule[i][j]=new Boolean(false);
				
		//	}
		//}
		
	
	
	
	
		mainGui.frame.setTitle("NyX");
		////////////////////////////////
		// Set GUI window layout manager
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
						   
		mainGui.availableSiteListModel = new LocationTableModel();
		mainGui.availableSiteList = new JTable(mainGui.availableSiteListModel);
		mainGui.availableSiteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		JPanel availablePanel = new JPanel();
		availablePanel.setLayout(new BorderLayout());

		JScrollPane avPane = new JScrollPane();
		avPane.getViewport().setView(mainGui.availableSiteList);
		availablePanel.add(avPane, BorderLayout.CENTER);
		availablePanel.setBorder(BorderFactory.createTitledBorder("Available Locations"));
		mainGui.availableSiteList.setRowHeight(20);

		main.add(availablePanel);
		
		mainGui.availableSiteList.getSelectionModel().addListSelectionListener(mainGui.new RowListener());
		
			
		
		TableColumn c;
		c = mainGui.availableSiteList.getColumn((Object) mainGui.availableSiteList.getColumnName(0));
		c.setHeaderValue((Object) (new String("ID")));
		c = mainGui.availableSiteList.getColumn((Object) mainGui.availableSiteList.getColumnName(1));
		c.setHeaderValue((Object) (new String("Name")));
		//c = mainGui.availableSiteList.getColumn((Object) mainGui.availableSiteList.getColumnName(2));
		//c.setHeaderValue((Object) (new String("Protocol")));
		c = mainGui.availableSiteList.getColumn((Object) mainGui.availableSiteList.getColumnName(2));
		c.setHeaderValue((Object) (new String("Address")));
		
		
		JPanel visitedPanel = new JPanel();
		visitedPanel.setLayout(new BorderLayout());
		mainGui.newContentPane= new TableDemo();
		
		//JScrollPane pane = new JScrollPane();
		//pane.getViewport().setView(visitedSiteList);
		visitedPanel.add(mainGui.newContentPane,BorderLayout.CENTER);
		visitedPanel.setBorder(BorderFactory.createTitledBorder("Rules Selection"));
	  

		main.add(visitedPanel);

			// Column names
	
		
		
		
		JPanel p = new JPanel();
		JButton b = new JButton(REFRESHLABEL);
		b.addActionListener(mainGui.new refreshListener());
		p.add(b);
		
		b = new JButton(STOPLABEL);
		b.addActionListener(mainGui.new stopListener());
		p.add(b);
		
		b = new JButton(MOVELABEL);
		b.addActionListener(mainGui.new moveListener());
		p.add(b);
		
		main.add(p);
		
		mainGui.frame.getContentPane().add(main, BorderLayout.CENTER);
		mainGui.frame.setSize(400, 400);
		mainGui.frame.setVisible(true);
		
		
	}
	
	
	public void setup(MainGui mainGui){
		
		
		///////////////////from agent generator//////////////////
		mg=mainGui;
		Runtime rt = Runtime.instance();
		Profile p = new ProfileImpl();
		p.setParameter(Profile.MAIN_HOST,"admin");
		cc = rt.createMainContainer(p);
		
		if (cc != null) {
			
			try {
				Object[] arg = new Object[2];
				arg[0]=mainGui;
				
				ac0 = cc.createNewAgent("nyxMonitor","agent.MonitorAgent.AgMonitor",arg);
				ac1 = cc.createNewAgent("pp1","agent.AddressBookAgent.AddressBookAgent",arg);
				
				ac0.start();
				ac1.start();
				
				System.out.println(ac0.getName());
				
				
				//ac2 = cc.createNewAgent("pp2","nyx.agent.ResponseAgent.ResponseAgent",null);
				//ac2.start();
				
				//ac3 = cc.createNewAgent("pp3","nyx.agent.SensorAgent.AgSensor",null);
				//ac3.start();
				//String testRule="alert tcp $EXTERNAL_NET any -> $HOME_NET 12345:12346 (msg:\"Sin-Fin attack\"; flags:SF; content:\"GetInfo|0D|\"; reference:arachnids,403; classtype:misc-activity; sid:110; rev:4;)";
				
				//boolean loop=true;
				//while(loop){
					
					//ac1.putO2AObject((Object)info,true);
					//System.out.println(Ag.ac3.getState().getName());
					
					//if((ac3.getState().getName()=="Idle"||ac3.getState().getName()=="Active")&&(newLoc!=null)){
					
						//ac3.putO2AObject((Object)testRule,true);
						//ac3.move(newLoc);
						//System.out.println(newLoc.getID());
						//loop=false;
					//}
					
												
				}
				//return ac;
				catch (Exception e) {
					e.printStackTrace();
				}
		}
		///////////////////////////////////////////////////////
		
		
	}
	public void startProxy(Location loc){
		
		
		if (cc != null) {
			
			try {
			
					
				proxyController = cc.createNewAgent("pa->","agent.ProxyAgent.ProxyAgent",null);
				proxyController.start();
				
				
				
				boolean loop=true;
				
				while(loop){
					if((proxyController.getState().getName()=="Idle"||proxyController.getState().getName()=="Active")&&(loc!=null)){
					
						proxyController.move(loc);
						System.out.println(loc.getID());
						loop=false;
					}
				}
				
				
				
											
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	}
		
	public void startResponse(String name,String content){
		
		String text="test";
		String[] command=new String[30];
		
		Date d=new Date();
		DateFormat f=DateFormat.getDateTimeInstance();
		String ds=f.format(d);
		
		text=ds+"->"+name+"->"+content;
		
		AppendFile appendFile=new AppendFile();
		appendFile.append("/home/pramod/Desktop/nyx.log",text);
		
		
		Pattern pattern = Pattern.compile( "->([0-9]*)");
		Matcher matcher = pattern.matcher(name);
		matcher.reset(name);
		if(matcher.find()){
			
			
			
			if (cc != null) {
				
				try {
					responseController[responseCounter] = cc.createNewAgent("ra->"+responseCounter,"agent.ResponseAgent.ResponseAgent",null);
					responseController[responseCounter].start();
					
					
					ResponseHandler responseHandler=new ResponseHandler();
					
					if(responseHandler.isFound(content)){
					
						int cnt=0;
						while(responseHandler.getCommand(cnt)!=null){
							
							command[cnt]=responseHandler.getCommand(cnt);
							CommandRunner cr=new CommandRunner();
							cr.executeCommand(command[cnt]);
							cnt++;
						}
						//System.out.println(responseHandler.getCommand());
					}
					
					if(command[0]==null){
						command[0]="echo Intrusion Detected";
					}
					
					
					boolean loop=true;
					while(loop){
						
						if((responseController[responseCounter].getState().getName()=="Idle"||responseController[responseCounter].getState().getName()=="Active")&&(agentLocation[(new Integer(matcher.group(1))).intValue()]!=null)){
							responseController[responseCounter].putO2AObject((Object)command,true);
							responseController[responseCounter].move(agentLocation[(new Integer(matcher.group(1))).intValue()]);
							System.out.println(agentLocation[(new Integer(matcher.group(1))).intValue()].getID());
							loop=false;
						}
						
													
					}
					responseCounter++;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
						
			System.out.println("response agent send.............."+matcher.group(1));
		}
	}
	public void startSensor(Location loc){
		
		
		
		
		
	if (cc != null) {
				
				try {
				
						
					sensorController[sensorCounter] = cc.createNewAgent("sa->"+sensorCounter,"agent.SensorAgent.AgSensor",null);
					sensorController[sensorCounter].start();
					agentLocation[sensorCounter]=loc;
					
					
						int noRow=newContentPane.tm.getRowCount();
					  boolean flag=false;
					  String[] temprule=new String[1000];
					  String[] rule=new String[10000];
					  int cntStart=0;
					  int cntEnd=0;
					  for(int i=0;i<noRow;i++){
						  if(newContentPane.tm.getValueAt(i,1).equals(new Boolean(true))){
							  
							  RuleHandler rh=new RuleHandler();
							  temprule=rh.getRules("/home/pramod/rules/"+((String)newContentPane.tm.getValueAt(i,0)));
							  cntEnd=rh.noOfRules()+cntStart;
							  int l=0;
							  for(int k=cntStart;k<cntEnd;k++){
								  
								  rule[k]=temprule[l];
								  l++;
							  }
							  cntStart=cntEnd;
						  }
					  }
					
					
					
					String testRule="alert tcp $EXTERNAL_NET any -> $HOME_NET 12345:12346 (msg:\"Sin-Fin attack\"; flags:SF; content:\"GetInfo|0D|\"; reference:arachnids,403; classtype:misc-activity; sid:110; rev:4;)";
					
					boolean loop=true;
					
					while(loop){
						if((sensorController[sensorCounter].getState().getName()=="Idle"||sensorController[sensorCounter].getState().getName()=="Active")&&(loc!=null)){
						
							sensorController[sensorCounter].putO2AObject((Object)rule,true);
							sensorController[sensorCounter].move(loc);
							System.out.println(loc.getID());
							loop=false;
						}
					}
					
					sensorCounter++;
					
												
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		}
	
		
	}
	public void updateLocations(Iterator list) {
	    availableSiteListModel.clear();
	    for ( ; list.hasNext(); ) {
	    	Object obj = list.next();
	      availableSiteListModel.add((Location) obj);
	    }
	    availableSiteListModel.fireTableDataChanged();
	  }
	
	public void updateLocations(Location loc){
		
		availableSiteListModel.add(loc);
		
	    availableSiteListModel.fireTableDataChanged();
	    //availableSiteList.repaint();
	}
	
	public void setLabel(String s){
		System.out.println(s);
	}
	
	
	private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
            	System.out.println("rowSelected"+availableSiteList.getSelectedRow());
            	//int sel=availableSiteList.getSelectedRow();
            	//newLoc = availableSiteListModel.getElementAt(sel);
            	for(int i=0;i<newContentPane.tm.getRowCount();i++){
            		
            		newContentPane.tm.setValue(i, new Boolean(false));
            	}
            	newContentPane.repaint();
            	return;
            }
            
        }
    }
	
	
	class moveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			
			  Location dest;
			  
			  		  
			  int sel = availableSiteList.getSelectedRow();
			  if (sel >= 0)
				  dest = availableSiteListModel.getElementAt(sel);
			  else
				  dest = availableSiteListModel.getElementAt(0);
			  
			  Date d=new Date();
			  DateFormat f=DateFormat.getDateTimeInstance();
			  String ds=f.format(d);
			  
			  
			  ///perform the action of starting sensor agent
			  //TableDemo.MyTableModel tb=newContentPane.new MyTableModel();
			  int noRow=newContentPane.tm.getRowCount();
			  boolean flag=false;
			  for(int i=0;i<noRow;i++){
				  if(newContentPane.tm.getValueAt(i,1).equals(new Boolean(true))){
					  flag=true;
					  System.out.println("true");
				  }
			  }
			  if(!flag){
				  JOptionPane.showMessageDialog(
	                        frame,
	                        "Sorry, \"" + "\" "
	                        + "isn't a valid action.\n"
	                        + "Please select one rule "
	                        + ".",
	                        "Try again",
	                        JOptionPane.ERROR_MESSAGE);
			  }
			  else{
				  
				  startSensor(dest);
				  
			  }
			  
		}
	}
	
	
	
	class refreshListener implements ActionListener{
			
			
		public void actionPerformed(ActionEvent event){
				///perform the action refreshing the table
				System.out.println("refreshing table");
				try{
					ac1.kill();
					
					if(cc!=null){
						Object[] arg = new Object[2];
						arg[0]=mg;
						ac1 = cc.createNewAgent("pp"+cnt,"agent.AddressBookAgent.AddressBookAgent",arg);
						ac1.start();
						cnt++;
					}
					//ac1.start();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				//updateLocations(l);
				
								
			}
	}
	
	class stopListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
		
			Location dest;//=new Location();
			  
	  		  
			  int sel = availableSiteList.getSelectedRow();
			  if (sel >= 0){
				  
				  dest = availableSiteListModel.getElementAt(sel);
				  String address;
				  System.out.println("stopping sensor agent"+dest.getID()+"......");
				  
				  for(int i=0;i<sensorCounter;i++){
					  
					  try{
						  
						  if(sensorController[i]!=null){
							  address=sensorController[i].getName();
							  System.out.println(address);
							  Pattern pattern = Pattern.compile( "@([a-zA-Z0-9]*):");
							  Matcher matcher = pattern.matcher(address);
							  //matcher.reset(name);
							  if(matcher.find()){
								  
								  System.out.println("agent found");
								  if(matcher.group(1).equals((String)dest.getAddress())){
									  sensorController[i].kill();
								  }
									  
							  }
							  
						  }
					  }
					  catch(Exception ex){
						  startProxy(dest);
					  }
					  
					  
				  }
			  }
			  else{
				
				  JOptionPane.showMessageDialog(
	                        frame,
	                        "Sorry, \"" + "\" "
	                        + "isn't a valid action.\n"
	                        + "Please select one agent "
	                        + ".",
	                        "Try again",
	                        JOptionPane.ERROR_MESSAGE);
			  }
			 
			  
							
		}
	}
	
}


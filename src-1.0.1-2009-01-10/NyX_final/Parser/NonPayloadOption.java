/**
 * 
 */

/**
 * @author pushpeshwor
 *
 */
public class NonPayloadOption {

	private String fragoffset=null;
	private String ttl=null;
	private String tos=null;
	private String id=null;
	private String ipopts=null;
	private String fragbits=null;
	private String dsize=null;
	private String flags=null;
	private String flow=null;
	private String flowbits=null;
	private String seq=null;
	private String ack=null;
	private String window=null;
	private String itype=null;
	private String icode=null;
	private String icmp_id=null;
	private String icmp_seq=null;
	private String rpc=null;
	private String ip_proto=null;
	private boolean sameip=false;
	
	//getters
	public String getFragoffset(){
		return fragoffset;
	}
	
	public String getTtl(){
		return ttl;
	}
	
	public String getTos(){
		return tos;
	}
	
	public String getId(){
		return id;
	}
	
	public String getIpopts(){
		return ipopts;
	}
	
	public String getFragbits(){
		return fragbits;
	}
	
	public String getDsize(){
		return dsize;
	}
	
	public String getFlags(){
		return flags;
	}
	
	public String getFlow(){
		return flow;
	}
	
	public String getFlowbits(){
		return flowbits;
	}
	
	public String getSeq(){
		return seq;
	}
	
	public String getAck(){
		return ack;
	}
	
	public String getWindow(){
		return window;
	}
	
	public String getItype(){
		return itype;
	}
	
	public String getIcode(){
		return icode;
	}
	
	public String getIcmp_id(){
		return icmp_id;
	}
	
	public String getIcmp_seq(){
		return icmp_seq;
	}
	
	public String getRpc(){
		return rpc;
	}
	public String getIp_proto(){
		return ip_proto;
	}
	public boolean getSameip(){
		return sameip;
	}
	
	
	//setters
	

	public void setFragoffset(String s){
		 fragoffset=s;
	}
	
	public void setTtl(String s){
		 ttl=s;
	}
	
	public void setTos(String s){
		 tos=s;
	}
	
	public void setId(String s){
		 id=s;
	}
	
	public void setIpopts(String s){
		 ipopts=s;
	}
	
	public void setFragbits(String s){
		 fragbits=s;
	}
	
	public void setDsize(String s){
		 dsize=s;
	}
	
	public void setFlags(String s){
		 flags=s;
	}
	
	public void setFlow(String s){
		 flow=s;
	}
	
	public void setFlowbits(String s){
		 flowbits=s;
	}
	
	public void setSeq(String s){
		seq=s;
	}
	
	public void setAck(String s){
		 ack=s;
	}
	
	public void setWindow(String s){
		 window=s;
	}
	
	public void setItype(String s){
		 itype=s;
	}
	
	public void setIcode(String s){
		 icode=s;
	}
	
	public void setIcmp_id(String s){
		 icmp_id=s;
	}
	
	public void setIcmp_seq(String s){
		 icmp_seq=s;
	}
	
	public void setRpc(String s){
		 rpc=s;
	}
	public void setIp_proto(String s){
		 ip_proto=s;
	}
	public void setSameip(boolean s){
		 sameip=s;
	}
	

	
}

/**
 * 
 */

/**
 * @author root
 *
 */
public class PayloadOption {
	
	private String content=null;
	private boolean nocase=false;
	private boolean rawbytes=false;
	private String depth=null;
	private String offset=null;
	private String distance=null;
	private String within=null;
	private boolean http_client_body=false;
	private boolean http_uri=false;
	private String uricontent=null;
	private String urilen=null;
	private String isdataat=null;
	private String pcre=null;
	private String byte_test=null;
	private String byte_jump=null;
	private boolean ftpbounce=false;
	private String asnl=null;
	
	
	//getters
	public String getContent(){
		return content;
	}
	
	public boolean getNocase(){
		return nocase;
	}
	
	public boolean getRawbytes(){
		return rawbytes;
	}
	
	public String getDepth(){
		return depth;
	}
	
	public String getOffset(){
		return offset;
	}
	
	public String getDistance(){
		return distance;
	}
	
	public String getWithin(){
		return within;
	}
	
	public boolean getHttp_client_body(){
		return http_client_body;
	}
	
	public boolean getHttp_uri(){
		return http_uri;
	}
	
	public String getUricontent(){
		return uricontent;
	}
	
	public String getUrilen(){
		return urilen;
	}
	
	public String getIsdataat(){
		return isdataat;
	}
	
	public String getPcre(){
		return pcre;
	}
	
	public String getByte_test(){
		return byte_test;
	}
	
	public String getByte_jump(){
		return byte_jump;
	}
	
	public boolean getFtpbounce(){
		return ftpbounce;
	}
	
	public String getAsnl(){
		return asnl;
	}
	
		
	//setters
	

	public void setContent(String s){
		content=s;
	}
	
	public void setNocase(boolean s){
		nocase=s;
	}
	
	public void setRawbytes(boolean s){
		rawbytes=s;
	}
	
	public void setDepth(String s){
		depth=s;
	}
	
	public void setOffset(String s){
		offset=s;
	}
	
	public void setDistance(String s){
		distance=s;
	}
	
	public void setWithin(String s){
		within=s;
	}
	
	public void setHttp_client_body(boolean s){
		http_client_body=s;
	}
	
	public void setHttp_uri(boolean s){
		http_uri=s;
	}
	
	public void setUricontent(String s){
		uricontent=s;
	}
	
	public void setUrilen(String s){
		urilen=s;
	}
	
	public void setIsdataat(String s){
		isdataat=s;
	}
	
	public void setPcre(String s){
		pcre=s;
	}
	
	public void setByte_test(String s){
		byte_test=s;
	}
	
	public void setByte_jump(String s){
		byte_jump=s;
	}
	
	public void setFtpbounce(boolean s){
		ftpbounce=s;
	}
	
	public void setAsnl(String s){
		asnl=s;
	}
	
	

}

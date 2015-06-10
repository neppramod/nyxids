/**
 * 
 */
import java.util.regex.*;
/**
 * @author pushpeshwor
 *
 */
public class Parser {

	/**
	 * @param args
	 */
		
	private Rules rules=new Rules();
	
	public Rules getRules(String testRule){
		
		IpAddress ipAddress=new IpAddress();
		PortNumber portNumber=new PortNumber();
		RuleHeader ruleHeader=new RuleHeader();
		RuleOption ruleOption=new RuleOption();
		
		
		/////////////////////////for rule header//////////////////////
		
		//protocols
		Pattern pattern = Pattern.compile( "tcp|udp|ip|icmp" );
		Matcher matcher = pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			ruleHeader.setProtocols(matcher.group());
		
		//directions
		pattern=Pattern.compile("->|<>");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			ruleHeader.setDirection(matcher.group());
		
		//ip address for networks
		
		pattern=Pattern.compile("([0-9]{1,3}[.]+[0-9]{1,3}[.]+[0-9]{1,3}[.]+[0-9]{1,3}[/]{0,1}\\d{1,2})\\s+([a-zA-Z0-9:-]+)\\s+([-<>]{1,2})\\s+([0-9]{1,3}[.]+[0-9]{1,3}[.]+[0-9]{1,3}[.]+[0-9]{1,3}[/]{0,1}\\d{1,2})\\s+([a-zA-Z0-9:-]+)");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		
		if(matcher.find()){
		
		
		
			ipAddress.setDestination(matcher.group(4));
			ipAddress.setSource(matcher.group(1));
			ruleHeader.setIpAddress(ipAddress);
			
			//port number
			portNumber.setDestination(matcher.group(5));
			portNumber.setSource(matcher.group(2));
			ruleHeader.setPortNumber(portNumber);
		}
		
		rules.setRuleHeader(ruleHeader);
		
		//System.out.println(ruleHeader.getProtocols());
		
		
		////////////////////////////////rules option///////////////////////
		
		//general rule
		GeneralOption generalOption=new GeneralOption();
		
		//msg
		pattern=Pattern.compile("msg:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find()){
			generalOption.setMsg(matcher.group(1));
			//System.out.println(matcher.group(1));
		}
		//reference
		pattern=Pattern.compile("reference:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setReference(matcher.group(1));
		
		
		//gid
		pattern=Pattern.compile("gid:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setGid(matcher.group(1));
		
		
		//sid
		pattern=Pattern.compile("sid:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setSid(matcher.group(1));
		
		
		//rev
		pattern=Pattern.compile("rev:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setRev(matcher.group(1));
		
		
		//classtype
		pattern=Pattern.compile("classtype:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setClasstype(matcher.group(1));
		
		
		//priority
		pattern=Pattern.compile("priority:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setPriority(matcher.group(1));
		
		
		
		//metadata
		pattern=Pattern.compile("metadata:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			generalOption.setMetadata(matcher.group(1));
		
		
		///////payload option
		PayloadOption payloadOption=new PayloadOption();
		
		//content
		pattern=Pattern.compile("content:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setContent(matcher.group(1));
		
		//nocase
		pattern=Pattern.compile("nocase;");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		payloadOption.setNocase(matcher.find());
		
		//rawbytes
		pattern=Pattern.compile("rawbytes;");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		payloadOption.setRawbytes(matcher.find());
		
		//depth
		pattern=Pattern.compile("depth:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setDepth(matcher.group(1));
		
		//offset
		pattern=Pattern.compile("offset:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setOffset(matcher.group(1));
		
		//distance
		pattern=Pattern.compile("distance:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setDistance(matcher.group(1));
		
		//within
		pattern=Pattern.compile("within:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setWithin(matcher.group(1));
		
		//http_client_body
		pattern=Pattern.compile("http_client_body;");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		payloadOption.setHttp_client_body(matcher.find());
		
		//http_uri
		pattern=Pattern.compile("http_uri;");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		payloadOption.setHttp_uri(matcher.find());
		
		
		//uricontent
		pattern=Pattern.compile("uricontent:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setUricontent(matcher.group(1));
		
		//urilen
		pattern=Pattern.compile("urilen:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setUrilen(matcher.group(1));
		
		//isdataat
		pattern=Pattern.compile("isdataat:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setIsdataat(matcher.group(1));
		
		//pcre
		pattern=Pattern.compile("pcre:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setPcre(matcher.group(1));
		
		//byte_test
		pattern=Pattern.compile("byte_test:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setByte_test(matcher.group(1));
		
		//byte_jump
		pattern=Pattern.compile("byte_jump:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setByte_jump(matcher.group(1));
		
		
		//asnl
		pattern=Pattern.compile("asnl:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			payloadOption.setAsnl(matcher.group(1));
		
		//ftpbounce
		pattern=Pattern.compile("ftpbounce;");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		payloadOption.setFtpbounce(matcher.find());
	
	
	
		///////nonpayload option
		NonPayloadOption nonpayloadOption=new NonPayloadOption();
		
		//fragoffset
		pattern=Pattern.compile("fragoffset:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setFragoffset(matcher.group(1));
		
				

		//ttl
		pattern=Pattern.compile("ttl:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setTtl(matcher.group(1));
		

		//tos
		pattern=Pattern.compile("tos:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setTos(matcher.group(1));
		

		//id
		pattern=Pattern.compile("Id:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setId(matcher.group(1));
		

		//ipopts
		pattern=Pattern.compile("ipopts:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setIpopts(matcher.group(1));
		

		//fragbits
		pattern=Pattern.compile("fragbits:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setFragbits(matcher.group(1));
		
		

		//dsize
		pattern=Pattern.compile("dsize:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setDsize(matcher.group(1));
		
		

		//flags
		pattern=Pattern.compile("flags:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setFlags(matcher.group(1));
		
		

		//flow
		pattern=Pattern.compile("flow:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setFlow(matcher.group(1));
		
		

		//flowbits
		pattern=Pattern.compile("flowbits:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setFlowbits(matcher.group(1));
		
		

		//seq
		pattern=Pattern.compile("seq:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setSeq(matcher.group(1));
		
		

		//ack
		pattern=Pattern.compile("ack:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setAck(matcher.group(1));
		
		

		//window
		pattern=Pattern.compile("window:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setWindow(matcher.group(1));
		
		

		//itype
		pattern=Pattern.compile("itype:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setItype(matcher.group(1));
		
		

		//icode
		pattern=Pattern.compile("icode:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setIcode(matcher.group(1));
		
		

		//icmp_id
		pattern=Pattern.compile("icmp_id:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setIcmp_id(matcher.group(1));
		
		

		//icmp_seq
		pattern=Pattern.compile("icmp_seq:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setIcmp_seq(matcher.group(1));
		
		

		//rpc
		pattern=Pattern.compile("rpc:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setRpc(matcher.group(1));
		
		

		//ip_proto
		pattern=Pattern.compile("ip_proto:\\s*([a-zA-Z0-9-;:,./\\s]*);");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		if(matcher.find())
			nonpayloadOption.setIp_proto(matcher.group(1));
		
		
		//sameip
		pattern=Pattern.compile("sameip;");
		matcher=pattern.matcher(testRule);
		matcher.reset(testRule);
		nonpayloadOption.setSameip(matcher.find());
	
		
		
		ruleOption.setGeneralOption(generalOption);
		ruleOption.setPayloadOption(payloadOption);
		ruleOption.setNonPayloadOption(nonpayloadOption);
		
		rules.setRuleOption(ruleOption);
	
		
		return rules;
	}

}

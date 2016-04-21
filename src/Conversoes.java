
public class Conversoes {
	public static byte[] converteASCIIParaByteArray(String s, boolean padding){
		int tamanho;
		if(padding){
			tamanho = s.length() % 16;
			if(tamanho == 0){
				tamanho = 16;
			}
		}else{
			tamanho = 0;
		}
		byte[] arrayResult = new byte[s.length() + tamanho];
		for(int i = 0; i < s.length(); i++){
			arrayResult[i] = (byte) s.charAt(i);
		}
		byte pad = (byte) tamanho;
		for(int i = s.length(); i < s.length() + tamanho; i++){
			arrayResult[i] = pad;
		}
		return arrayResult;
	}
	public static String converteByteArrayToHexString(byte[] a){
		char hexDig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i < a.length; i++){
			buf.append(hexDig[(a[i] >> 4) & 0x0f]);
			buf.append(hexDig[a[i] & 0x0f]);
		}
		return buf.toString();
	}
	public static byte[] converteHexStringToByteArray(String s){
		int tamanho = s.length() / 2;
		byte[] arrayResult = new byte[tamanho];
		for(int i = 0; i < tamanho; i++){
			String hex = s.substring(i * 2, i * 2 + 2);
			Integer valor = Integer.parseInt(hex, 16);
			arrayResult[i] = valor.byteValue();
		}
		return new byte[0];
	}
}

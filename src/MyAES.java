import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class MyAES {
	private final String ALGORITMO = "AES/CBC/NoPadding";
	private Key chaveAES;
	private IvParameterSpec ivps;
	
	public MyAES(String chave, String iv){
		byte[] ivArray = Conversoes.converteASCIIParaByteArray(iv, false);
		ivps = new IvParameterSpec(ivArray);
		
		byte[] chaveArray = Conversoes.converteHexStringToByteArray(chave);
		chaveAES = new SecretKeySpec(chaveArray, "AES");
	}
	
	public String encriptar(String texto) throws Exception{
		Cipher c = Cipher.getInstance(ALGORITMO);
		c.init(Cipher.ENCRYPT_MODE, chaveAES, ivps);
		byte[] textoArray = Conversoes.converteHexStringToByteArray(texto);
		byte[] cipherText = c.doFinal(textoArray);
		return Conversoes.converteByteArrayToHexString(cipherText);
	}
	
	public String desencriptar(String texto) throws Exception{
		Cipher c = Cipher.getInstance(ALGORITMO);
		c.init(Cipher.DECRYPT_MODE, chaveAES, ivps);
		byte[] textoArray = Conversoes.converteHexStringToByteArray(texto);
		byte[] mensagem = c.doFinal(textoArray);
		return Conversoes.converteByteArrayToHexString(mensagem);
	}
}

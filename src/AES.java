
public class AES {
	public static void main(String[] args) throws Exception {
		String chave = "140b41b22a29beb4061bda66b6747e14";
		String iv = "1234567890123456";
		String texto = "texto que vai ser encriptado";
		String textoEmHexa = Conversoes.converteByteArrayToHexString(Conversoes.converteASCIIParaByteArray(texto, true));
		
		System.out.println("Texto original:");
		System.out.println(texto);
		System.out.println("Texto em hexa:");
		System.out.println(textoEmHexa);
		
		MyAES aes = new MyAES(chave, iv);
		String textoEncriptado = aes.encriptar(textoEmHexa);
		System.out.println("Texto encriptado com AES:");
		System.out.println(textoEncriptado);
		
		String textoDesencriptado = aes.encriptar(textoEncriptado);
		System.out.println("Texto desencriptado apartir do resutado amterior:");
		System.out.println(textoDesencriptado);
	}
}

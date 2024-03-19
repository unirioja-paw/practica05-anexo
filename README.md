# Práctica 5

Anexo de código de ayuda para la realización de la práctica.


## Sesión 1

### Búsqueda de artículos
- `ArticuloSearchCriteria`
- `ArticuloDAO`


## Sesión 2

### Comprobación usuario/contraseña

```java
public class UsuarioDaoMySQL implements UsuarioDAO {

	public Usuario findUsuarioByExample(Usuario example) throws ExcepcionDeAplicacion 
	{
		// se codifica el password introducido por el usuario para buscarlo en BD
		String encodedPassword = encodeValue(example.getPassword(), "SHA");
		// TODO
		 
	}

    private String encodeValue(String value, String algorithm) {
        byte[] bytes = value.getBytes();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (Exception exception) {
            logger.error("Error getting MessageDigest instance", exception);
            return value;
        }
        messageDigest.reset();
        messageDigest.update(bytes);
        byte[] digestBytes = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b = 0; b < digestBytes.length; b++) {
            if ((digestBytes[b] & 0xFF) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString((digestBytes[b] & 0xFF), 16));
        }
        return stringBuffer.toString();
    }

}
```

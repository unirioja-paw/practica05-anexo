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

## Sesión 3

### Registro de nuevo cliente


Desplegable para seleccionar provincia:


```html
	<select name="provincia">
		<option value="">- Elige -</option>
		<c:forEach var="p" items="A Coruña,Álava,Albacete,Alicante,Almería,Araba,Asturias,Ávila,Badajoz,Baleares,Barcelona,Bizkaia,Burgos,Cáceres,Cádiz,Cantabria,Castellón,Ceuta,Ciudad Real,Córdoba,Cuenca,Gerona,Gipuzkoa,Guipuzcoa,Girona,Granada,Guadalajara,Huelva,Huesca,Illes Balears,Jaén,La Coruña,La Rioja,Las Palmas,León,Lérida,Lleida,Lugo,Madrid,Málaga,Melilla,Murcia,Navarra,Orense,Ourense,Palencia,Pontevedra,Salamanca,Santa Cruz de Tenerife,Segovia,Sevilla,Soria,Tarragona,Teruel,Toledo,Valencia,Valladolid,Vizcaya,Zamora,Zaragoza">
			<option value="${p}">${p}</option>
		</c:forEach>
	</select>
```



Método `register` para registrar el nuevo cliente:

```java
public interface ClienteDAO {

    public Cliente findByUsername(String username) throws ExcepcionDeAplicacion;
    
    public Cliente register(Cliente cliente, String password) throws ExcepcionDeAplicacion;
}
```


### Envío de mails

Revisa la clase `JavaxMailer` y el código del paquete `es.unirioja.paw.service` en general.

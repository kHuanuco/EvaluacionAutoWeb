#language: es
@testfeatureQLAB
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para comprar productos en linea
#Escenario: Validación del precio de un producto
#  Dado estoy en la página de la tienda
#  Y me logueo con mi usuario "karen.huanuco@pucp.pe" y clave "prueba123"
#  Cuando navego a la categoria "Clothes" y subcategoria "Men"
#  Y agrego 2 unidades del primer producto al carrito
#  Entonces valido en el popup la confirmación del producto agregado
#  Y valido en el popup que el monto total sea calculado correctamente
# Cuando finalizo la compra
# Entonces valido el titulo de la pagina del carrito
# Y vuelvo a validar el calculo de precios en el carrito

  @testfeatureQLABScenarioOutline
  Esquema del escenario: Validación del precio de un producto Outline
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "<email>" y clave "<password>"
    Cuando navego a la categoria "<categoria>" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito
    Ejemplos:
    |email|password|categoria|Detalle|
    |karen.huanuco@pucp.pe|prueba123|Clothes|Funciona|
    |karen.huanuco@pucp.pe|prueba003|Clothes|Se cuelga porque no encuentro el boton de cerrar sesion|
    |karen.huanuco@pucp.pe|prueba123|Autos|Se cae, porque no existe esa categoria                   |



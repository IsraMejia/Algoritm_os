# Leer los valores de la compra y el monto recibido
compra = float(input("Ingrese el valor total de la compra: "))
monto_recibido = float(input("Ingrese el monto recibido: "))

# Calcular el cambio total
cambio_total = monto_recibido - compra

# Inicializar una lista para almacenar las denominaciones de moneda
denominaciones = [10, 5, 2, 1, 0.5]

# Inicializar un diccionario para almacenar la cantidad de monedas disponibles
cambio_disponible = {10: 1, 5: 4, 2: 3, 1: 3, 0.5: 8}

# Calcular la cantidad de monedas de cada denominación que se deben dar
for denominacion in denominaciones:
    if cambio_total >= denominacion:
        cantidad = int(cambio_total / denominacion)
        cambio_disponible[denominacion] = cantidad
        cambio_total -= cantidad * denominacion

# Imprimir el número de monedas de cada denominación que se deben dar como cambio
for denominacion, cantidad in cambio_disponible.items():
    if cantidad > 0:
        print(f"{cantidad} moneda(s) de {denominacion} pesos")

from models.repository import guardar
def validar_personaje(personaje):

    if not personaje.nombre.strip():
        return "El nombre no puede estar vacío."

    if type(personaje.nivel) != int or personaje.nivel < 1 or personaje.nivel > 100:
        return "El nivel debe ser un número entero entre 1 y 100."

    if personaje.clase not in ["Guerrero", "Mago", "Arquero"]:
        return "La clase no es válida."

    return None


def crear_personaje_servicio(personaje):

    error = validar_personaje(personaje)

    if error:
        return error

    guardar(personaje)
    return None
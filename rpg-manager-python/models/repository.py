from models.personaje import Personaje

personajes = []

personajes.append(
    Personaje("Maximo", "Guerrero", 1, 100)
)

personajes.append(
    Personaje("Merlin", "Mago", 2, 100)
)


def obtener_todos():
    return personajes[:]


def guardar(personaje):
    personajes.append(personaje)
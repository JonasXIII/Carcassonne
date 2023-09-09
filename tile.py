CITY = 'C'
ROAD = 'R'
FIELD = 'F'

class Tile:
    def __init__(self, sides, city_connections, field_connections, shield, cloister, id):
        self.sides = sides
        self.city_connections = city_connections
        self.field_connections = field_connections
        self.shield = shield
        self.cloister = cloister
        self.id = id

def makeTileStack():
    tiles = []
    tiles.append(Tile([CITY, CITY, CITY, CITY], [1,1,1,1], [0,0,0,0,0,0,0,0], True, False, 0))
    tiles.append(Tile([CITY, CITY, CITY, FIELD], [1,1,1,0], [0,0,0,0,0,0,1,1], True, False, 1))
    for i in range(3):
        tiles.append(Tile([CITY, CITY, CITY, FIELD], [1,1,1,0], [0,0,0,0,0,0,1,1], False, False, 2))
    for i in range(2):
        tiles.append(Tile([CITY, CITY, CITY, ROAD], [1,1,1,0], [0,0,0,0,0,0,1,2], True, False, 3))
    tiles.append(Tile([CITY, CITY, CITY, ROAD], [1,1,1,0], [0,0,0,0,0,0,1,2], False, False, 4))
    

    


    return tiles

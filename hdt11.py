# UVG - Algoritmos y Estructuras de Datos
# HDT 11: Implementacion del algoritmo de Floyd con NetworkX
# Rodrigo Arriaza, Alejandro Chaclan y Sebastian Galindo

import networkx as nx
#import matplotlib.pyplot as plt

G = nx.Graph()

file = open("guategrafo.txt", "r")
data = file.readlines()
file.close()

for linea in data:
    cadena = linea.split(", ")
    G.add_node(cadena[0])
    G.add_node(cadena[1])
    G.add_edge(cadena[0], cadena[1], weight = int(cadena[2]))

print nx.number_of_nodes(G)
ruta = nx.floyd_warshall_predecessor_and_distance(G, weight="weight")
losnodos=G.nodes()
origen = raw_input("Seleccione el origen: "+"/".join(losnodos))
while origen not in G.nodes():
    print "Ingreso incorrecto"
    origen = raw_input("Seleccione el origen: "+"/".join(losnodos))
    
destino =raw_input("Seleccione el destino: "+"/".join(losnodos))
while destino not in G.nodes():
    print "Ingreso incorrecto"
    destino = raw_input("Seleccione el destino: "+"/".join(losnodos))
    
# ruta[0] contiene las ciudades visitadas
# ruta[1] contiene el valor del recorrido

print "Las ciudades por las que debes pasar son:"
flag = 1
last_predecesor = ruta[0][origen][destino]
while flag:
    print last_predecesor
    predecesor = last_predecesor
    if origen==last_predecesor:
        flag = 0
    else:
        last_predecesor = ruta[0][origen][predecesor]
        

print "Esto equivale en km a:"
print ruta[1][origen][destino]

centro = nx.center(G, e=None)
print "El centro(s) del grafo es: "+", ".join(centro)

print ""
desea_corregir = raw_input("Esta bloqueada alguna carretera? (Si/No)")
if desea_corregir == "Si":
    print "Escriba de donde a donde esta bloqueada la carretera"
    print ""
    aristas = G.edges()
    arista = raw_input(aristas)
    nodos = arista.split(", ")
    print ""    #corregir manera de evaluar si esta el edge o no
    if nodos[0] not in G.nodes():
        flg = 1
    while flg:
        print "Esa carretera no existe, debe escribir Origen, Destino "
        arista = raw_input(aristas)
        nodos = arista.split(", ")
        
    G.remove_edge(nodos[0], nodos[1])
    rutaN = nx.floyd_warshall_predecessor_and_distance(G, weight="weight")
    print "Las ciudades por las que debes pasar son:"
    flag = 1
    last_predecesor = rutaN[0][origen][destino]
    while flag:
        print last_predecesor
        predecesor = last_predecesor
        if origen==last_predecesor:
            flag = 0
        else:
            last_predecesor = rutaN[0][origen][predecesor]
    print "Esto equivale en km a:"
    print rutaN[1][origen][destino]
    centro = nx.center(G, e=None)
    print "El centro(s) del grafo es: "+", ".join(centro)

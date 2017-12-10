%punto(X,Y,Numero)
:-dynamic punto/3.

%Hechos que representan el dominio de numeros con los que se trabajará.
num(1).
num(2).
num(3).
num(4).
num(5).
num(6).
num(7).
num(8).
num(9).

%Recibe unas coordenadas del tablero e inserta el numero N, con previa verificacion en fila, columna y caja.
movimiento_valido(X,Y,N):-num(N),not(punto(_,Y,N)),not(punto(X,_,N)),Z is ceiling(X/3),W is ceiling(Y/3),not(caja_con(Z,W,N)),mi_asserta(punto(X,Y,N)).

%Encuentro todas las posiciones de la caja y las recorro para encontrar N.
caja_con(Z,W,N):-posiciones(Z,W,L),recorrer(L,N).
posiciones(Z,W,Pos):-findall([X,Y],(num(X),num(Y),X=<Z*3,X>=(Z-1)*3+1,Y=<W*3,Y>=(W-1)*3+1),Pos).
recorrer([[X,Y]|Zs],N):-punto(X,Y,N);recorrer(Zs,N).

%Asserta propio, sensible al backtracking.
mi_asserta(punto(X,Y,Z)):-asserta(punto(X,Y,Z)).
mi_asserta(punto(X,Y,Z)):-retract(punto(X,Y,Z)),fail.

%Predicado que resolvera el sudoku, recorriendolo de izquierda a derecha y de arriba hacia abajo.
resolver(10,9).
resolver(10,Y):-Z is Y+1,resolver(1,Z).
resolver(X,Y):-not(punto(X,Y,_)),movimiento_valido(X,Y,_),Z is X+1,resolver(Z,Y).
resolver(X,Y):-punto(X,Y,_),Z is X+1,resolver(Z,Y).

%Chequea que con la configuracion actual, en todas las casillas hay un numero posible a insertar.
hay_posibilidad(10,9).
hay_posibilidad(10,Y):-Z is Y+1,hay_posibilidad(1,Z).
hay_posibilidad(X,Y):-X<10,Y<10,not(punto(X,Y,_)),num(N),not(punto(_,Y,N)),not(punto(X,_,N)),Z is ceiling(X/3),W is ceiling(Y/3),not(caja_con(Z,W,N)),Q is X+1,!,hay_posibilidad(Q,Y).
hay_posibilidad(X,Y):-X<10,Y<10,punto(X,Y,_),Z is X+1,!,hay_posibilidad(Z,Y).

solucion():-hay_posibilidad(1,1),resolver(1,1).



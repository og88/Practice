CFLAGS = -g -Wall  
CC = gcc


objects = mt-collatz.o 

mt-collatz: $(objects)
	$(CC) -pthread -o mt-collatz $(objects)


mt-collatz.o: mt-collatz.c
Collatz_computations.c.o: Collatz_computaions.c
.PHONY : clean
clean: 
	rm mt-collatz $(objects)

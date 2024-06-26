#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Collatz_computations.c"

void p();

int main(int argc, char *argv[])
{
	if (pthread_mutex_init(&lock, NULL) != 0) //Checks to see if a lock can be created
	{
		printf("\n mutex init failed\n");
		return 1;
	}


	buildarray();      //Builds an array to hold information needed. The stopping time, occurance rate, time
	N = atoi(argv[1]); //Sets the number of elements to the first parameter
	T = atoi(argv[2]); //Sets number of threads to second parameter
	pthread_t threads[T];  //Creates T threads

	//printf("%i %i\n", N,T);
	clock_t begin = clock();  //Records start of processes
	//while(x <= N)
	//{
	int id[T];
		for(t = 0; t < T; t++)
		{
			id[t] = t;
			pthread_create(&threads[t], NULL, compare, &id[t]);  //Creates the necessary threads
		}

		for(t=0; t<T; t++) //Loop joins all threads together
		{
			pthread_join(threads[t], NULL);
		}
	//}
	pthread_mutex_destroy(&lock);  //Destroys lock
	clock_t end = clock();  //records the stopping time of the threads

	double time_spent = (double)(end - begin) / CLOCKS_PER_SEC; //Calculates the time the process ran for
	printf("%f\n",time_spent);
	p();
	//printarray();
}

void p()
{
	int i;
		for(i = 0; i < (sizeof(count)/ sizeof(count[0]));i++)
		{
			printf("%.f, %.f, %f\n",count[i][0],count[i][1],count[i][2]);
		}
}



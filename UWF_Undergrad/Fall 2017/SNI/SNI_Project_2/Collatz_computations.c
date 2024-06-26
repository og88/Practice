/*
 * Collatz_computations.c
 *
 *  Created on: Oct 20, 2017
 *      Author: omarg
 */
int collats(int x);
int f(int x);
void buildarray();
void printarray();
void *compare(void * t);
void other(void *t);

int T;    //The number of threads to create.
long t; //Used in a for loop to select a thread.
double count[250][3];   //Array of stopping times and it's information
int n,  //n is the stopping time
N,      //N is the number of elements to be tested (2 -> N)
x = 2;  //We eclude 0 and 1 since their stopping time is 0
pthread_mutex_t lock;  //Create the lock item

void *compare(void *t)
{
	while(x < N)
	{
		pthread_mutex_lock(&lock); //Locks the critical section
		other(t);
		x++;
		pthread_mutex_unlock(&lock);
	}
		pthread_exit(NULL);
}

void other(void *t)
{
	//pthread_mutex_lock(&lock); //Locks the critical section
	if(x <= N)
	{
		collats(x);
		//printf("%i %i\n",*(int *)t , x);
	}
	int y;
	for(y = 0; y < (sizeof(count)/ sizeof(count[0]));y++) //Runs a loop to find the array location of the stopping time
	{
		if(n == count[y][0])
		{
			count[y][1]++;  //increments the count of the stopping time
		}
	}
}

/*Uses a for loop to place the variable 0 to n into an array of size n*/
void buildarray()
{
	int i;
	for(i = 0; i < (sizeof(count)/ sizeof(count[0]));i++)
	{
		count[i][0]= i;
		count[i][1]= 0;
	}
}
/*Prints the array and all parameters in a special format*/
void printarray()
{
	int i;
	for(i = 0; i < (sizeof(count)/ sizeof(count[0]));i++)
	{
		printf("<%.f, %.f, %f>\n",count[i][0],count[i][1],count[i][2]);
	}
}

/*Initial function to test wether x if greater than 0*/
int collats(int x)
{
	n = 0;
	if(x == 0)
	{
		return n; //if x is 0, 0 is returned
	}
	else
	{
		return f(x);  //If x is > than 0, x is passed into function f()
	}
}

/*Second part of the function. Tests if x is even or odd.*/
int f(int x)
{
	if((x % 2) != 0) //If x is odd, multiple by three and add 1
	{
		n++;         //Increment Stopping Time
		x = ((3*x)+1);
	}
	else            //If x is even, divide by two
	{
		n++;        //Increment Stopping Time
		x = (x/2);
	}
	if(x == 1)     //If x is one return x
	{
		return x;
	}
	else           //If x is not one, recurrence until it is.
	{
		f(x);
	}
	return x;
}

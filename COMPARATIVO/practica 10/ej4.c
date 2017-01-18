#include  <stdio.h>
#include <unistd.h>/*            por            getpid()            */
#include <sys/file.h>
#define  N (2000)


int main(void){
  FILE* f = fopen("seqno.txt","r+");

  int i, value;

  for (i=0; i<N; i++) {

    printf("%i\n",fileno(f) );
    lockf(fileno(f),F_LOCK,0); /////COMANDO PARA HACER EL LOCK
    fscanf(f,"%d", &value);
    value++;
    rewind(f);
    fprintf(f,"%6d\n", value);
    fflush(f);
    printf("Process id: %d, value: %d\n", getpid(), value);
    fflush(stdout);  /* forzar la escritura al archivo */
    lockf(fileno(f),F_ULOCK,0);

 }
}

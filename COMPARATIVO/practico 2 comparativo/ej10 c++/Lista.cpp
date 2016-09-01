#include <iostream>
#define MAX 5
class Lista{
private:
	int *items;
	int count;
public: 
	Lista(){
		items= new int[MAX];
		count=0;
	};
	int obtener(int index){    //hay que hacer que controle 
							//que el indice este dentro del arreglo
		
		if (index>0&&index<MAX){
			std::cout<<"entro al if";		
			return items[index];   
		}else throw 1; //
		
	}
};

int main(){
	Lista *p = new Lista();
	
	try{
	int a = p->obtener(7);
	}catch(int e){
		std::cout<<"excepcion "<<e<<"\n";

	}
	std::cout<<"Hola mundo c++ \n"<<"\n";

	return 0;
}


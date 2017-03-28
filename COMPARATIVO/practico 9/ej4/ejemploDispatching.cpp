#include <string>

#include <iostream>
using namespace std;


class Padre {
public:

	//si le saco el virtual hace dispatching estatico y usa el metodo definido en compilacion 
	//(en este caso hijo) va a dar soy el padre
	virtual string soyYo(){
		return "Soy el padre";
	}
	 void quiensoy(){
		cout <<soyYo()<< endl;
	}
};

class Hijo : public Padre {
public:
	string soyYo(){
		return "Soy el hijo";
	}
	
};

int main(){
	Padre *p = new Hijo();
	p->quiensoy();
	return 0;


}
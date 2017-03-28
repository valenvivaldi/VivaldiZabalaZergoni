#define MAX =5;
class Lista{
private:
	int *items;
	int count;
public: 
	Lista(){
		items= new int[MAX];
		count=0;
	}
	int obtener(int index){
		return items[index]
	}
};
int main(){
	Lista *p = new Lista()
	int a = p->obtener(7);
	return 0;
}


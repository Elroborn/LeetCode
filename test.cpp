#include<iostream>
#include<vector>
using namespace std;
class test{
public:
    void fun(){

    }

};
template<size_t m,size_t n>
void print_array(int (&a)[m][n]){
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            cout<<i<<" "<<j<<":"<<a[i][j]<<endl;
        }
    }
}
int main(){
    // int a1[5]; //里面值是随机的
    // int a2[6] = {1,2,3};//前三个指定，不足的补零，所以如果int a2[6] = {0}则全部初始为0
    // int* a3 = new int[5]; // 这样可以初始化为指定值，动态定义
    // int size1 = sizeof(a1)/sizeof(*a1);
    // for(int i=0;i<size1;i++){
    //     cout<<a1[i]<<endl;
    // }
    // int size2 = sizeof(a2)/sizeof(*a2);
    // for(int i=0;i<size2;i++){
    //     cout<<a2[i]<<endl;
    // }
    int a[2][3];
    print_array(a);
    return 0;
}
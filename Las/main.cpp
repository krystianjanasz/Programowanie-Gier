#include <iostream>
#include <chrono>
#include <thread>
#include <random>

using namespace std;

int main() {
    //ZMIENNE
    unsigned int forestSize;
    unsigned int fireProb;
    unsigned int selfIgnitionProb;
    unsigned int rebirthProb;
    int x,y;
    unsigned int generation;
    unsigned seed=chrono::system_clock::now().time_since_epoch().count();
    minstd_rand0 generator(seed);

    //PRZYGOTOWANIA
    cout<<"SYMALACJA PLONACEGO LASU\n";
    cout<<"Wprowadz liczbe N, rozmiar twojego lasu bedzie rowny N na N:\n>> ";
    cin>>forestSize;
    char forest[forestSize+2][forestSize+2];
    //'^'-drzewa,'*'-plonie drzewo,'.'-martwe drzewo
    for(unsigned int j=0;j<forestSize+1;++j)
    {
        for(unsigned int k=0;k<forestSize+2;++k)
        {
            forest[j][k]='.';
        }
    }
    for(unsigned int j=1;j<forestSize+1;++j)
    {
        for(unsigned int k=1;k<forestSize+1;++k)
        {
            forest[j][k]='^';
        }
    }
    cout<<"Czy chcesz wprowadzic plonace drzewo? (t-tak, n-nie)\n";
    char ans;
    cin>>ans;
    while(ans!='t' && ans!='n')
    {
        cout<<"Podano nierozpoznawalna odpowiedz: ";
        cin>>ans;
        cout<<"\n";
    }

    if(ans=='t')
    {
        cout<<"Wprowadz pozycje plonacego drzewa (wiersze i kolumny numerowane od 1)\n";
        cout<<"x: ";
        cin>>x;
        cout<<"y: ";
        cin>>y;
        while(x<=0 || x>forestSize || y<=0 || y>forestSize)
        {
            cout<<"To drzewo jest poza twoim lasem, podaj drzewo z twojego lasu.\n";
            cout<<"x: ";
            cin>>x;
            cout<<"y: ";
            cin>>y;
        }
        forest[y][x]='*';
    }
    cout << "\x1B[2J\x1B[H";
    cout<<"SYMALACJA PLONACEGO LASU\n";
    cout<<"Wprowadz prawdopodobienstwo zaplonu drzewa jesli drzewo obok plonie(w procentach)\n>> ";
    cin>>fireProb;
    while(fireProb<0 || fireProb>100)
    {
        cout<<"Prawdopodobienstwo powinno byc z przedzialu <0,100>.\n>> ";
        cin>>fireProb;
    }
    cout << "\x1B[2J\x1B[H";

    cout<<"SYMALACJA PLONACEGO LASU\n";
    cout<<"Wprowadz prawdopodobienstwo samozaplonu drzewa(w procentach):\n>> ";
    cin>>selfIgnitionProb;
    while(selfIgnitionProb<0 || selfIgnitionProb>100)
    {
        cout<<"Prawdopodobienstwo powinno byc z przedzialu <0,100>.\n>> ";
        cin>>selfIgnitionProb;
    }
    cout << "\x1B[2J\x1B[H";

    cout<<"SYMALACJA PLONACEGO LASU\n";
    cout<<"Wprowadz prawdopodobienstwo odrodzenia drzewa(w procentach):\n>> ";
    cin>>rebirthProb;

    while(rebirthProb<0 || rebirthProb>100)
    {
        cout<<"Prawdopodobienstwo powinno byc z przedzialu <0,100>.>> \n";
        cin>>rebirthProb;
    }
    cout << "\x1B[2J\x1B[H";

    cout<<"SYMALACJA PLONACEGO LASU\n";
    cout<<"Wprowadz liczbe generacji lasu:\n>> ";
    cin>>generation;

    cout<<"Symulacja rozpocznie sie za 4 sekundy.\n";
    for(unsigned int i=0; i<4;++i)
    {
        cout<<i<<"\n";
        this_thread::sleep_for(chrono::seconds(1));
    }
    cout << "\x1B[2J\x1B[H";
    char forestCopy[forestSize+2][forestSize+2];
    //PLONIE LAS
    for(unsigned int i=0; i<generation;++i)
    {
        this_thread::sleep_for(chrono::seconds(1));
        //KOPIOWANIE LASU
        for(unsigned int j=0;j<forestSize+2;++j)
        {
            for(unsigned int k=0;k<forestSize+2;++k)
            {
                forestCopy[j][k]=forest[j][k];
            }
        }

        for(unsigned int j=1;j<forestSize+1;++j)
        {
            for(unsigned int k=1;k<forestSize+1;++k)
            {
                cout<<forestCopy[j][k];
                switch(forestCopy[j][k])
                {
                    case '*':
                    {
                        forest[j][k]='.';
                        break;
                    }
                    case '.':
                    {
                        if(forestCopy[j-1][k-1]=='*' || forestCopy[j-1][k]=='*' || forestCopy[j-1][k+1]=='*')
                        {
                            break;
                        }
                        else if(forestCopy[j][k-1]=='*'|| forestCopy[j][k+1]=='*')
                        {
                            break;
                        }
                        else if(forestCopy[j+1][k-1]=='*' || forestCopy[j+1][k]=='*' || forestCopy[j+1][k+1]=='*')
                        {
                            break;
                        }
                        else
                        {
                            if(generator()%101<rebirthProb)
                            {
                                forest[j][k]='^';
                            }
                        }
                        break;
                    }
                    case '^':
                    {
                        if(forestCopy[j-1][k-1]=='*' || forestCopy[j-1][k]=='*' || forestCopy[j-1][k+1]=='*')
                        {
                            if(generator()%101<fireProb)
                            {
                                forest[j][k]='*';
                            }
                        }
                        else if(forestCopy[j][k-1]=='*'|| forestCopy[j][k+1]=='*')
                        {
                            if(generator()%101<fireProb)
                            {
                                forest[j][k]='*';
                            }
                        }
                        else if(forestCopy[j+1][k-1]=='*' || forestCopy[j+1][k]=='*' || forestCopy[j+1][k+1]=='*')
                        {
                            if(generator()%101<fireProb)
                            {
                                forest[j][k]='*';
                            }
                        }
                        else
                        {
                            if(generator()%101<selfIgnitionProb)
                            {
                                forest[j][k]='*';
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }
            }
            cout<<"\n";
        }
        cout<<"Generacja "<<i<<"\n";
        cout << "\x1B[2J\x1B[H";

    }
    return 0;
}
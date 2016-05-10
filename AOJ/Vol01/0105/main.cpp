#include <iostream>
#include <algorithm>
#include <string>
#include <map>
#include <vector>
using namespace std;

static map< string, vector< int > > dict;

int main(){
  while(true){
    string word;
    int page;
    cin >> word >> page;

    if(cin.eof()){
      break;
    }

    map< string, vector< int > >::iterator it
      = dict.find(word);
    if(it != dict.end()){
      (*it).second.push_back(page);
    }
    else{
      vector< int > vec;
      vec.push_back(page);
      dict.insert(pair< string, vector< int > > (word, vec));
    }
  }

  map< string, vector< int > >::iterator it
    = dict.begin();
  while(it != dict.end()){
    cout << (*it).first << endl;
    sort((*it).second.begin(), (*it).second.end());
    for(int i = 0; i < (*it).second.size(); i++){
      cout << (*it).second[i] << 
        ((i == ((*it).second.size() - 1)) ? "\n" : " ");
    }
    ++it;
  }

  return 0;
}

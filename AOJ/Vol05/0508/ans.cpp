#include<iostream>
#include<vector>
#include<map>
#include<set>
#include<bitset>
#include<algorithm>
#define F first
#define S second
using namespace std;
typedef pair<int,int> P;
int ans;

void dfs(vector<vector<int> >& G,int p,int cost,bitset<101>& visited)
{
  bool update = false;
  for(int i=0;i<G[p].size();i++)
  {
    int next = G[p][i];
    if(!visited[next])
    {
      visited[next] = 1;
      dfs(G,next,cost+1,visited);
      visited[next] = 0;
      update = true;
    }
  }
  if(!update)
    ans = max(ans,cost);
}

int main()
{
  int n;
  while(cin >> n,n)
  {
    vector<vector<int> > G;
    set<int> input;
    G.resize(101);
    for(int i=0;i<n;i++)
    {
      int a,b;
      cin >> a >> b;
      input.insert(a);
      input.insert(b);
      G[a].push_back(b);
      G[b].push_back(a);
    }

    ans = 2;
    for(set<int>::iterator it = input.begin();it != input.end();it++)
    {
      bitset<101> visited(0);
      visited[(*it)] = true;
      dfs(G,(*it),1,visited);

    }
    cout << ans << endl;
  }
  return 0;
}

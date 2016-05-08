#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define STREQ(s1, s2) !strcmp(s1, s2)

typedef struct _Node {
  int key;
  struct _Node *left, *right, *parent;
} Node;

static Node *root = NULL;

static void insert(Node *z){
  Node *parent = NULL, *node = root;

  while(node != NULL){
    parent = node;
    if(z->key < node->key){
      node = node->left;
    }
    else{
      node = node->right;
    }
  }

  z->parent = parent;

  if(parent == NULL){
    root = z;
  }
  else if(z->key < parent->key){
    parent->left = z;
  }
  else{
    parent->right = z;
  }
}

static void inorder_tree_walk(const Node *tree){
  if(tree == NULL){
    return;
  }
  inorder_tree_walk(tree->left);
  printf(" %d", tree->key);
  inorder_tree_walk(tree->right);
}

static void preorder_tree_walk(const Node *tree){
  if(tree == NULL){
    return;
  }
  printf(" %d", tree->key);
  preorder_tree_walk(tree->left);
  preorder_tree_walk(tree->right);
}

static int find(int key){
  Node *node = root;

  while(node != NULL){
    if(node->key == key){
      return 1;
    }
    if(key < node->key){
      node = node->left;
    }
    else{
      node = node->right;
    }
  }

  return 0;
}

static int delete(int key){
  Node *node = root, tmp;

  if(!find(key)){
    return 0;
  }

  while(node != NULL){
    if(node->key == key){
      break;
    }
    if(key < node->key){
      node = node->left;
    }
    else{
      node = node->right;
    }
  }

  tmp = node->left;

}

int main(void){
  int m, k, i;
  char command[16];
  Node *z;
  scanf("%d", &m);
  for(i = 0; i < m; i++){
    scanf("%s", command);
    if(STREQ(command, "insert")){
      scanf("%d", &k);
      z = malloc(sizeof(Node));
      z->key = k;
      z->left = z->right = z->parent = NULL;
      insert(z);
    }
    else if(STREQ(command, "print")){
      inorder_tree_walk(root);
      putchar('\n');
      preorder_tree_walk(root);
      putchar('\n');
    }
    else if(STREQ(command, "find")){
      scanf("%d", &k);
      if(find(k)){
        printf("yes\n");
      }
      else{
        printf("no\n");
      }
    }
  }

  return 0;
}

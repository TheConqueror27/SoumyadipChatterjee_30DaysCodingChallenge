#include <bits/stdc++.h>
using namespace std;

class node {
public:
    int val;
    node* left;
    node* right;
    int ht;
};

int getHeight(node* n) {
    if (n == nullptr) return -1;
    return n->ht;
}

int getBalanceFactor(node* n) {
    if (n == nullptr) return 0;
    return getHeight(n->left) - getHeight(n->right);
}

node* rightRotate(node* y) {
    node* x = y->left;
    node* T2 = x->right;

    x->right = y;
    y->left = T2;

    y->ht = 1 + max(getHeight(y->left), getHeight(y->right));
    x->ht = 1 + max(getHeight(x->left), getHeight(x->right));

    return x;
}

node* leftRotate(node* x) {
    node* y = x->right;
    node* T2 = y->left;

    y->left = x;
    x->right = T2;

    x->ht = 1 + max(getHeight(x->left), getHeight(x->right));
    y->ht = 1 + max(getHeight(y->left), getHeight(y->right));

    return y;
}

node* insert(node* root, int val) {

    // Normal BST insertion
    if (root == nullptr) {
        node* newNode = new node();
        newNode->val = val;
        newNode->left = nullptr;
        newNode->right = nullptr;
        newNode->ht = 0;
        return newNode;
    }

    if (val < root->val) {
        root->left = insert(root->left, val);
    }
    else if (val > root->val) {
        root->right = insert(root->right, val);
    }
    else {
        return root;
    }

    // Update height
    root->ht = 1 + max(getHeight(root->left),
                        getHeight(root->right));

    // Get balance factor
    int balance = getBalanceFactor(root);

    // LL Case
    if (balance > 1 && val < root->left->val) {
        return rightRotate(root);
    }

    // RR Case
    if (balance < -1 && val > root->right->val) {
        return leftRotate(root);
    }

    // LR Case
    if (balance > 1 && val > root->left->val) {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }

    // RL Case
    if (balance < -1 && val < root->right->val) {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }

    return root;
}

void preorder(node* root) {
    if (root != nullptr) {
        cout << root->val << " ";
        preorder(root->left);
        preorder(root->right);
    }
}

int main() {

    node* root = nullptr;

    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);

    cout << "Preorder Traversal of AVL Tree:\n";
    preorder(root);

    return 0;
}
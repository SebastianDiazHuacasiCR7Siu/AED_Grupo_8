package bstreelinklistinterfgeneric;


import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import bstreeInterface.BinarySearchTree;
import Exceptions.ExceptionIsEmpty;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
        }
    }

    private Node root;

    public LinkedBST() {
        this.root = null;
    }

    // Insertar
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) throws ItemDuplicated {
        if (node == null) return new Node(data);

        int cmp = data.compareTo(node.data);
        if (cmp == 0)
            throw new ItemDuplicated("Elemento duplicado: " + data);
        else if (cmp < 0)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);

        return node;
    }

    // Buscar
    public E search(E data) throws ItemNoFound {
        Node found = search(root, data);
        if (found == null) throw new ItemNoFound("No se encontró: " + data);
        return found.data;
    }

    private Node search(Node node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node;
        else if (cmp < 0) return search(node.left, data);
        else return search(node.right, data);
    }

    // Eliminar
    public void delete(E data) throws ExceptionIsEmpty {
        if (root == null)
            throw new ExceptionIsEmpty("Árbol vacío");
        root = delete(root, data);
    }

    private Node delete(Node node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = delete(node.left, data);
        else if (cmp > 0)
            node.right = delete(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = findMin(node.right);
            node.data = min.data;
            node.right = delete(node.right, min.data);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // toString - estructura visual del árbol
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, "", "");
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb, String prefix, String childrenPrefix) {
        if (node != null) {
            sb.append(prefix).append(node.data).append("\n");
            if (node.left != null || node.right != null) {
                buildString(node.left, sb, childrenPrefix + "├── ", childrenPrefix + "│   ");
                buildString(node.right, sb, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    // Método público para probar el recorrido In-Orden
public void printInOrder() {
    System.out.print("In-Order: ");
    inOrder(root);
    System.out.println();
}

private void inOrder(Node node) {
    if (node != null) {
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}

// Método público para probar el recorrido Pre-Orden
public void printPreOrder() {
    System.out.print("Pre-Order: ");
    preOrder(root);
    System.out.println();
}

private void preOrder(Node node) {
    if (node != null) {
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

// Método público para probar el recorrido Post-Orden
public void printPostOrder() {
    System.out.print("Post-Order: ");
    postOrder(root);
    System.out.println();
}

private void postOrder(Node node) {
    if (node != null) {
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}

// Encuentra el valor mínimo en el subárbol con raíz en 'node'
private E findMinNode(Node node) throws ItemNoFound {
    if (node == null) {
        throw new ItemNoFound("Subárbol vacío, no se puede encontrar el mínimo.");
    }

    // Recorre hacia la izquierda hasta el nodo más pequeño
    Node current = node;
    while (current.left != null) {
        current = current.left;
    }

    // Verifica si el valor mínimo existe usando search()
    search(current.data); // puede lanzar ItemNoFound
    return current.data;
}

// Encuentra el valor máximo en el subárbol con raíz en 'node'
private E findMaxNode(Node node) throws ItemNoFound {
    if (node == null) {
        throw new ItemNoFound("Subárbol vacío, no se puede encontrar el máximo.");
    }

    // Recorre hacia la derecha hasta el nodo más grande
    Node current = node;
    while (current.right != null) {
        current = current.right;
    }

    // Verifica si el valor máximo existe usando search()
    search(current.data); // puede lanzar ItemNoFound
    return current.data;
    }

    public E obtenerMinimo() throws ItemNoFound {
    return findMinNode(root);
    }

public E obtenerMaximo() throws ItemNoFound {
    return findMaxNode(root);
    }

//Método para destruir nodos.    
public void destroyNodes() throws ExceptionIsEmpty {
    if (root == null)
        throw new ExceptionIsEmpty("El árbol ya está vacío.");
    root = null;
}


//Método de nodos totales 
public int countAllNodes() {
    return countAllNodes(root);
}

private int countAllNodes(Node node) {
    if (node == null) return 0;
    return 1 + countAllNodes(node.left) + countAllNodes(node.right);
}

//Método de nodos - no - hojas
public int countNodes() {
    return countNonLeafNodes(root);
}

private int countNonLeafNodes(Node node) {
    if (node == null || (node.left == null && node.right == null))
        return 0;

    return 1 + countNonLeafNodes(node.left) + countNonLeafNodes(node.right);
}

//Método de altura de subárbol con raíz 
public int height(E x) {
    Node current = root;
    while (current != null) {
        int cmp = x.compareTo(current.data);
        if (cmp == 0) break;
        else if (cmp < 0) current = current.left;
        else current = current.right;
    }

    if (current == null) return -1; // no se encontró

    // Calcular altura desde current
    java.util.Stack<Node> stack = new java.util.Stack<>();
    java.util.Map<Node, Integer> heights = new java.util.HashMap<>();

    stack.push(current);
    while (!stack.isEmpty()) {
        Node node = stack.peek();
        if ((node.left == null || heights.containsKey(node.left)) &&
            (node.right == null || heights.containsKey(node.right))) {
            int leftHeight = node.left == null ? -1 : heights.get(node.left);
            int rightHeight = node.right == null ? -1 : heights.get(node.right);
            heights.put(node, 1 + Math.max(leftHeight, rightHeight));
            stack.pop();
        } else {
            if (node.right != null && !heights.containsKey(node.right)) stack.push(node.right);
            if (node.left != null && !heights.containsKey(node.left)) stack.push(node.left);
        }
    }

    return heights.get(current);
}

//Método de amplitud 
public int amplitude(int level) {
    if (root == null) return 0;

    java.util.Queue<Node> queue = new java.util.LinkedList<>();
    queue.add(root);
    int currentLevel = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        if (currentLevel == level) return size;

        for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        currentLevel++;
    }

    return 0;
}

//Método público de área de árbol
public int areaBST() {
    if (root == null) return 0;

    int leafCount = 0;
    int maxHeight = -1;

    java.util.Queue<Node> queue = new java.util.LinkedList<>();
    java.util.Queue<Integer> heights = new java.util.LinkedList<>();
    queue.add(root);
    heights.add(0);

    while (!queue.isEmpty()) {
        Node node = queue.poll();
        int height = heights.poll();
        maxHeight = Math.max(maxHeight, height);

        if (node.left == null && node.right == null) leafCount++;

        if (node.left != null) {
            queue.add(node.left);
            heights.add(height + 1);
        }

        if (node.right != null) {
            queue.add(node.right);
            heights.add(height + 1);
        }
    }

    return leafCount * maxHeight;
}

//Método para dibujar y graficar el árbol 
public void drawBST() {
    System.out.println(this.toString());
}



}

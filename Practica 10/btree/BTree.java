package btree;

import java.util.ArrayList;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E cl) {
        if (isEmpty()) {
            root = new BNode<>(orden - 1);
            root.keys.set(0, cl);
            root.count = 1;
        } else {
            up = false;
            E med = push(root, cl);
            if (up) {
                BNode<E> newRoot = new BNode<>(orden - 1);
                newRoot.keys.set(0, med);
                newRoot.count = 1;
                newRoot.childs.set(0, root);
                newRoot.childs.set(1, nDes);
                root.setParent(newRoot);
                nDes.setParent(newRoot);
                root = newRoot;
            }
        }
    }

    private E push(BNode<E> current, E cl) {
        BNode.SearchResult result = current.searchNode(cl);
        if (result.found) {
            System.out.println("Clave duplicada: " + cl);
            up = false;
            return null;
        }

        int k = result.position;
        if (current.childs.get(k) == null) {
            return putInLeaf(current, cl, null, k);
        } else {
            E med = push(current.childs.get(k), cl);
            if (up) return putInLeaf(current, med, nDes, k);
            else return null;
        }
    }

    private E putInLeaf(BNode<E> current, E cl, BNode<E> rd, int k) {
        if (!current.nodeFull(orden)) {
            putNode(current, cl, rd, k);
            up = false;
            return null;
        } else {
            return divideNode(current, cl, rd, k);
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        for (int i = current.count; i > k; i--) {
            current.keys.set(i, current.keys.get(i - 1));
            current.childs.set(i + 1, current.childs.get(i));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        if (rd != null) rd.setParent(current);
        current.count++;
    }

    private E divideNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int posMed = (orden - 1) / 2;
        int n = orden - 1;

        ArrayList<E> tempKeys = new ArrayList<>(n + 1);
        ArrayList<BNode<E>> tempChilds = new ArrayList<>(orden + 1);

        for (int i = 0; i <= n; i++) tempKeys.add(null);
        for (int i = 0; i <= orden; i++) tempChilds.add(null);

        for (int i = 0; i < n; i++) {
            tempKeys.set(i, current.keys.get(i));
            tempChilds.set(i, current.childs.get(i));
        }
        tempChilds.set(n, current.childs.get(n));

        for (int i = n; i > k; i--) {
            tempKeys.set(i, tempKeys.get(i - 1));
            tempChilds.set(i + 1, tempChilds.get(i));
        }

        tempKeys.set(k, cl);
        tempChilds.set(k + 1, rd);

        E med = tempKeys.get(posMed);
        current.count = 0;

        for (int i = 0; i < posMed; i++) {
            current.keys.set(i, tempKeys.get(i));
            current.childs.set(i, tempChilds.get(i));
            if (current.childs.get(i) != null) current.childs.get(i).setParent(current);
            current.count++;
        }
        current.childs.set(posMed, tempChilds.get(posMed));
        if (current.childs.get(posMed) != null) current.childs.get(posMed).setParent(current);

        nDes = new BNode<>(orden - 1);
        for (int i = posMed + 1, j = 0; i <= n; i++, j++) {
            nDes.keys.set(j, tempKeys.get(i));
            nDes.childs.set(j, tempChilds.get(i));
            if (nDes.childs.get(j) != null) nDes.childs.get(j).setParent(nDes);
            nDes.count++;
        }
        nDes.childs.set(n - posMed, tempChilds.get(n + 1));
        if (nDes.childs.get(n - posMed) != null) nDes.childs.get(n - posMed).setParent(nDes);

        up = true;
        nDes.setParent(current.getParent());
        return med;
    }

    // Método para imprimir en forma de tabla
    public void printTreeTable() {
        System.out.printf("%-10s %-20s %-10s %-20s\n", "Id.Nodo", "Claves Nodo", "Id.Padre", "Id.Hijos");
        printNodeTable(this.root);
    }

    private void printNodeTable(BNode<E> current) {
        if (current == null) return;

        String claves = "";
        for (int i = 0; i < current.count; i++) {
            claves += current.keys.get(i);
            if (i < current.count - 1) claves += ", ";
        }

        String padre = (current.getParent() != null) ? String.valueOf(current.getParent().idNode) : "--";

        ArrayList<String> hijos = new ArrayList<>();
        for (int i = 0; i <= current.count; i++) {
            BNode<E> hijo = current.childs.get(i);
            if (hijo != null) hijos.add(String.valueOf(hijo.idNode));
        }

        System.out.printf("%-10s %-20s %-10s %-20s\n", current.idNode, "(" + claves + ")", padre, hijos.toString());

        for (int i = 0; i <= current.count; i++) {
            printNodeTable(current.childs.get(i));
        }
    }
}


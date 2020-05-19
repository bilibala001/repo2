package com.tree;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * @author ng
 * @date 2019/11/27-10:07
 * 前序遍历：根节点->左子树->右子树（根->左->右）
 * 中序遍历：左子树->根节点->右子树（左->根->右）
 * 后序遍历：左子树->右子树->根节点（左->右->根）
 */
public class TraverseTest {
    /**
     * 不要按ctrl+shift+f格式化
     *                  0
     *             /        \
     *           a           b
     *          / \         /  \
     *        c    d       e    f
     *      /   \  / \           \
     *     g    h  i  j            n
     *              \
     *               t
     *                \
     *                 z
     *
     * @return
     */
    static Node initTree() {
        Node root = new Node('0');
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');
        Node i = new Node('i');
        Node j = new Node('j');
        Node n = new Node('n');
        //为了测试depth；
        Node t = new Node('t');
        Node z = new Node('z');

        root.leftchild = a;
        root.rightchild = b;
        a.leftchild = c;
        a.rightchild = d;
        b.leftchild = e;
        b.rightchild = f;
        c.leftchild = g;
        c.rightchild = h;
        d.leftchild = i;
        d.rightchild = j;
        f.rightchild = n;
        i.rightchild = t;
        t.rightchild = z;
        return root;
    }
    public static void main(String[] args) {
        Node root = initTree();
         System.out.println("双方都要修改");
        
        preTraverse(root);
        Runtime runtime =Runtime.getRuntime();
        long l1 = runtime.freeMemory();
        long l2 = runtime.maxMemory();
        /*long totalMemory = runtime.totalMemory();
        System.out.println(l1+"\t"+l2);
        System.out.println(totalMemory);*/
//        midTraverse(root);
//        postTraverse(root);

//        System.out.println(getDepth(root));
//        getMaxLengthBewteenTwoNode(root);
    }

    /**
     * 对遍历获取节点进行操作
     *
     * @param node
     */
    static void handleNode(Node node) {
        //
        int i = getMaxLengthBewteenTwoNode(node);
        System.out.print(node);
        System.out.print("双方都修改-本地也修改");
        System.out.print(i + " ");
    }

    /**
     * 路径，就是 / 的个数。
     *
     * @param root
     * @return
     */
    private static int getMaxLengthBewteenTwoNode(Node root) {
        if (root == null) return 0;
        int depthleft = getDepth(root.leftchild);
        int depthright = getDepth(root.rightchild);
        return depthleft + depthright;
    }


    /**
     * 获取tree的深度，depth；
     * 思路：每个节点的深度 = 该节点到其所有叶节点的最大深度,而不是计算每个node到root的深度。
     *
     * @param mid
     * @return
     */
    private static int getDepth(Node mid) {
        if (mid == null) return 0;
        Node left = mid.leftchild, right = mid.rightchild;

        if ((left) == null && (right) == null) {
            return 1;
        }

        if ((left) != null && right == null) {
            return 1 + getDepth(left);
        }
        if ((left) == null && right != null) {
            return 1 + getDepth(right);
        }
        if ((left) != null && right != null) {
            return 1 + Math.max(getDepth(left), getDepth(right));
        }
        return 0;
    }

    /**
     * 左，右，中
     *
     * @param mid
     */
    private static void postTraverse(Node mid) {
        if (mid != null) {
            postTraverse(mid.leftchild);
            postTraverse(mid.rightchild);
            handleNode(mid);
        }
    }

    /**
     * 中序遍历
     *
     * @param mid
     */
    private static void midTraverse(Node mid) {
        if (mid != null) {
            midTraverse(mid.leftchild);
            handleNode(mid);
            midTraverse(mid.rightchild);
        }
    }

    /**
     * 前序遍历:中，左，右
     * 先打印，再遍历子树
     *
     * @param mid
     */
    private static void preTraverse(Node mid) {
        Node left, right;
        if(mid ==null) {
            return;
        }
        handleNode(mid);
        if ((left = mid.leftchild) != null) {
            preTraverse(left);
        }
        if ((right = mid.rightchild) != null) {
            preTraverse(right);
        }
    }


}

package smelville;

import java.util.ArrayList;

public class QuestionIterator {
    QuestionIterator(ArrayList<TreeItem> list){
        root_ = new TreeNode();
        TreeNode current = root_, prev = root_;
        TreeItem item;
        list_ = list;
        whichNode = 0;
        if(list.size() < 1){
            root_.question_ = "Is it alive?";
            root_.left_ = new TreeNode();
            root_.right_ = new TreeNode();
            root_.left_.object_ = "dog";
            root_.right_.object_ = "rock";
        }
        else {
            root_ = organizeTree();
            whichNode = 0;
        }
    }

    TreeNode root_;
    ArrayList<TreeItem> list_;
    int numNodes;
    int whichNode;

    void prepareList(){
        list_ = new ArrayList<>();
        addItem(root_);
        numNodes = list_.size();
    }

    void addItem(TreeNode current){
        list_.add(new TreeItem(current.left_ == null && current.right_ == null ? current.object_: current.question_, current.left_ == null && current.right_ == null));

        if(current.left_ != null)
            addItem(current.left_);
        if(current.right_ != null)
            addItem(current.right_);
    }

    TreeItem next(){
        return list_.get(whichNode++);
    }

    boolean hasNext(){
        if(whichNode < numNodes)
            return true;
        return false;
    }

    TreeNode getRoot(){
        return root_;
    }

    TreeNode organizeTree(){
        TreeNode current = new TreeNode();

        TreeItem item = list_.get(whichNode++);

        if(item.isObject_){
            current.object_ = item.text_;
        }
        else{
            current.question_ = item.text_;
            current.left_ = new TreeNode();
            current.right_ = new TreeNode();
            current.left_ = organizeTree();
            current.right_ = organizeTree();
        }

        return current;
    }
}

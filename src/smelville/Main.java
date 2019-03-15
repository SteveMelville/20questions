package smelville;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        QuestionTree questionTree = new QuestionTree();
        DatabaseManager mngr = new DatabaseManager();
        ArrayList<TreeItem> list = mngr.getList(), temp = new ArrayList<TreeItem>();
        QuestionIterator iter = new QuestionIterator(list);

        TreeNode tree = iter.getRoot();
        iter.root_ = questionTree.askQuestions(tree);

        iter.prepareList();

        while(iter.hasNext()){
            temp.add(iter.next());
        }

        list = temp;

        System.out.println(list.size());
        mngr.saveList(list);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smelville;

import java.util.*;

/**
 *
 * @author toavi
 */
public class QuestionTree {
    
    public TreeNode askQuestions(TreeNode tree){
        root_ = tree;
        Boolean answerToContinue = true;
        
        while(answerToContinue){
            System.out.println("\nThink of an object and I will try to guess it. ");
            TreeNode current = root_;
            String response, question;
            
            while(current != null){
                System.out.println(current.question_);
                response = input.nextLine();

                if(getAnswer(response)){
                    if(current.left_.question_ == null){
                        System.out.println("Is it a " + current.left_.object_ + "?");
                        response = input.nextLine();
                        if(getAnswer(response)){
                            System.out.println("I win!");
                            break;
                        } else {
                            System.out.println("That is unfortunate. What was it?");
                            response = input.nextLine();
                            
                            System.out.println("Please type a question whose answer is yes for a " + response + " and no for " + current.left_.object_ + ".");
                            question = input.nextLine();
                            
                            TreeNode tempNode1 = new TreeNode(), tempNode2 = new TreeNode();
                            tempNode1.object_ = response;
                            tempNode2.object_ = current.left_.object_;
                            current.left_.question_ = question;
                            current.left_.object_ = null;
                            current.left_.left_ = tempNode1;
                            current.left_.right_ = tempNode2;
                            break;
                        }
                    } else {
                        current = current.left_;
                    }
                } else {
                    if(current.right_.question_ == null){
                        System.out.println("Is it a " + current.right_.object_ + "?");
                        response = input.nextLine();
                        if(getAnswer(response)){
                            System.out.println("I win!");
                            break;
                        } else {
                            System.out.println("That is unfortunate. What was it?");
                            response = input.nextLine();
                            
                            System.out.println("Please type a question whose answer is yes for a " + response + " and no for a " + current.right_.object_ + ".");
                            question = input.nextLine();
                            
                            TreeNode tempNode1 = new TreeNode(), tempNode2 = new TreeNode();
                            tempNode1.object_ = response;
                            tempNode2.object_ = current.right_.object_;
                            current.right_.question_ = question;
                            current.right_.object_ = null;
                            current.right_.left_ = tempNode1;
                            current.right_.right_ = tempNode2;
                            break;
                        }
                    } else {
                        current = current.right_;
                    }

                }
            }
            
            current = root_;
            System.out.println("Do you want to play again?");
            response = input.nextLine();
            answerToContinue = getAnswer(response);
        }
        return root_;
    }
    
    private boolean getAnswer(String answer){
        while(true){
            if(null == answer.toLowerCase()){
                System.out.println("I have no idea what your response means... try again");
                answer = input.nextLine();
            }else switch (answer.toLowerCase()) {
                case "no":
                    return false;
                case "yes":
                    return true;
                default:
                    System.out.println("I have no idea what your response means... try again");
                    answer = input.nextLine();
                    break;
            }
        }
    }
    
    Scanner input = new Scanner(System.in);
    TreeNode root_;
    

}

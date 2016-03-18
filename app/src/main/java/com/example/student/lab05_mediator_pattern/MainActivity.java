package com.example.student.lab05_mediator_pattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mName = "鳴人" ;
    private int mQuantity = 0 ; //初始值(數量)
    private int mPrice = 5 ;    //初始值(價錢)
    private StringBuilder mPriceMessage = new StringBuilder("NT$" + mPrice);
    private StringBuilder mQuantityMessage = new StringBuilder(mQuantity);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMessage();
    }

    private void displayMessage() {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(mPriceMessage);
    }      //輸出金額

    private void displayQuantity(){            //輸出數量
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view) ; //取數量值
        int start = 0 ;
        int end = mQuantityMessage.length() ;
        mQuantityMessage.delete(start , end).append(mQuantity) ;
        quantityTextView.setText(mQuantityMessage);
    }      //輸出數量

    public void DeletemPriceMessage(){
        int start = 0 ;
        int end = mPriceMessage.length() ;
        mPriceMessage.delete(start, end) ;
    }   //把字串mPriceMessage清除
    public void AppendmPriceMessage(){

        CheckBox checkBox = (CheckBox)findViewById(R.id.topping_CheckBox);

        mPriceMessage.append("Name: ")
                .append(mName)
                .append("\n")
                .append("臭豆腐")
                .append("\n")
                .append("加泡菜? ")
                .append(checkBox.isChecked())
                .append("\n");

        if(mQuantity == 0){
            mPriceMessage.append("Free");
        }else{
            mPriceMessage.append("數量: ")
                    .append(mQuantity)
                    .append("金額 :")
                    .append("NT$")
                    .append(mQuantity*mPrice)
                    .append("\n")
                    .append("Thank you!");}
    }   //最後的輸出字串

   public void Order(){
       DeletemPriceMessage();
       AppendmPriceMessage();
       displayMessage();
   }                  //執行button_Order
   public void decrement(){
       ++mQuantity ;
       displayQuantity();
   }              //執行decrement(( 加數量
   public void increment(){
       if (mQuantity > 0){
           --mQuantity ;
       }
       displayQuantity();
   }              //執行increment(( 減數量

    public void mediator(View view) {

        switch (view.getId()) {

            case R.id.button_Order :
                Order();
                break;
            case R.id.button_decrement :
                decrement();
                break;
            case R.id.button_increment :
                increment();
                break;
        }
    }
}

<script type="text/javascript">
  $(function(){
    
    //キーダウンが起きた時の処理を記述
    $(document).keydown(function(event){
      var keyCode = event.keyCode;
      //backspaceボタンの制御
      var obj = event.target;
      if(keyCode == 8){
        if((obj.tagName == "input" && obj.type == "text") || obj.tagName == "textarea"){
          //入力項目内では使用できるようにする
          if(!obj.readOnly && !obj.disabled){
            return true;
          }
        }
        return false;
      }
      //alt + ← ボタンの制御
      var altClick = event.altKey;
      if(altClick && (keyCode == 37 || keyCode == 39)){
        return false;
      }
    })
    
  });
</script> 
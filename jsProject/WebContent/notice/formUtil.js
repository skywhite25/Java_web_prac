/**
 * 입력데이터 처리를 위한 JS
 */

// 필수 입력 항목 검사 - obj - input tag 객체
//if(!requiure(input객체, "항목이름")) return false;
function require(obj, item){
	if(!obj.value){ // 입력란에 입력이 안되어있어요
		// 경고메시지
		alert(item + "은(는) 반드시 입력해야 합니다")
		// 커서 위치시키기
		obj.focus();
		// 데이터 전송(submit())를 취소키기는 데이터 false를 돌려준다.
		return false;
	}
	return true;
}

// 입력데이터의 길이 체크(~자 이상) - obj - input tag개체
//if(!checkLength(input객체, "항목이름", 길이)) return false;
function checkLeng(obj, item, len){
	if(obj.value.length < len){
		// 경고
		alert(item + "은(는) " + len + "자 이상 입력해야 합니다.")
		// 만약에 type이 password인 경우 사용자 눈에 보이지 않으므로 데이터를 제거한다.
		if(obj.type == "password") obj.value = "";
		// 커서를 위치시킨다.
		obj.focus();
		// submit을 취소하기위한 false를 return한다
		return false; 
	}
	// 데이터가 적당하다면 true를 리턴한다
	return true;
}
	function removeBlank(inputObj){
	//alert("removeBlank()");
	var v = inputObj.value;
	//alert("["+ v +"]");
	inputObj.value = v.trim();
	//alert("[" + inputObj.value + "]");
}

// 다음 항목으로 자동 이동이 되는 함수(keyup 이벤트를 사용하여야 한다.)
function goNext(thisObj, nextObj, len){
	// 현재 입력란의 값의 길이가 len에 도달하면 다음입력란으로 이동시켜 준다.
	if(thisObj.value.length >= len) nextObj.focus();
	
}
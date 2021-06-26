/**
 * 
 */

function checkBillingAddress() {

	if ($("#theSameAsShippingAddress").is(":checked")) {
		$(".billingAddress").prop("disabled", true);
	} else {
		$(".billingAddress").prop("disabled", false);
	}
}

function checkPasswordMatch() {

	var password = $("#txtNewPassword").val();
	var confirmPassword = $("txtConfirmPassword").val();

	if (password == "" && confirmPassword == "") {

		$("checkPasswordMatch").html("");
		$("updateUserInfoButton").prop('disabled', false);
	} else {

		if (password != confirmPassword) {

			$("#checkPasswordMatch").html("Password do not match!");
			$("#updateUserInfoButton").prop('disabled', true);
		} else {

			$("#checkPasswordMatch").html("Password match");
			$("#updateUserInfoButton").prop('disabled', false);
		}
	}
}

$(document).ready(function() {

	$(".cartItemQty").on('change', function() {
		var id = this.id;

		$('#update-item-' + id).css('display', 'inline-block');
	});

	$("#theSameAsShippingAddress").on('click', checkBillingAddress);
	$("txtConfirmPassword").keyup(checkPasswordMatch);
	$("txtNewPassword").keyup(checkPasswordMatch);
});

$('#featuredCarousel').carousel({
	interval: 10000
})

$('.carousel .carousel-item').each(function() {
	var minPerSlide = 3;
	var next = $(this).next();
	if (!next.length) {
		next = $(this).siblings(':first');
	}
	next.children(':first-child').clone().appendTo($(this));

	for (var i = 0; i < minPerSlide; i++) {
		next = next.next();
		if (!next.length) {
			next = $(this).siblings(':first');
		}

		next.children(':first-child').clone().appendTo($(this));
	}
});

/*Start random card border colors*/

$(document).ready(function() {
	$('.bor').each(function() {
		/*$(this).css('background-color', randomColor());*/
		$(this).css('border-color', randomColor());
	});
});

var colors = ['00', '33', '66', '99', 'cc'];
var rand = function() {
	return Math.floor(Math.random() * 5);
};

var randomColor = function() {
	var r = colors[rand()];
	var g = colors[rand()];
	var b = colors[rand()];
	return "#" + r + g + b;
};

/*End random card border colors*/

/*Start random card bg colors*/

$(document).ready(function() {
	$('.card1').each(function() {
		$(this).css('background-color', randomColor());
		/*$(this).css('border-color', randomColor1());*/
	});
	$('.card2').each(function() {
		$(this).css('background-color', randomColor());
		/*$(this).css('border-color', randomColor2());*/
	});
	$('.card3').each(function() {
		$(this).css('background-color', randomColor());
		/*$(this).css('border-color', randomColor3());*/
	});
	$('.cardHead').each(function() {
		$(this).css('background-color', randomColor());
		/*$(this).css('border-color', randomColor4());*/
	});
	
});

var colors = ['00', '33', '66', '99', 'cc'];
var rand = function() {
	return Math.floor(Math.random() * 5);
};

var randomColor1 = function() {
	var r = colors[rand()];
	var g = colors[rand()];
	var b = colors[rand()];
	return "#" + r + g + b;
};

var randomColor2 = function() {
	var r = colors[rand()];
	var g = colors[rand()];
	var b = colors[rand()];
	return "#" + r + g + b;
};

var randomColor3 = function() {
	var r = colors[rand()];
	var g = colors[rand()];
	var b = colors[rand()];
	return "#" + r + g + b;
};

var randomColor4 = function() {
	var r = colors[rand()];
	var g = colors[rand()];
	var b = colors[rand()];
	return "#" + r + g + b;
};

/*End random card bg colors*/
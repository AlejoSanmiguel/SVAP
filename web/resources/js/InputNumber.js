(function($) {
  $('body').on('input', ".input-number input[data-type='number']", function(e) {
    this.value = this.value.replace(/[^0-9.]/g, '');
    if(!this.value){
      var min = 10;
      if ($(this).data('min')) {
        min = parseInt($in.data('min'), 10);
      }
      $(this).val(min);
    }
  });

  $('body').on('change', ".input-number input[data-type='number']", function(e) {
    var $in = $(this);
    var min = 10;
    var max = 10000;
    var step = 1;
    if ($in) {
      if ($in.data('min')) {
        min = parseInt($in.data('min'), 10);
      }
      if ($in.data('max')) {
        max = parseInt($in.data('max'), 10);
      }
      if ($in.data('step')) {
        step = parseInt($in.data('step'), 10);
      }
      var inputVal = parseInt($in.val(), 10);
      if (inputVal > max) {
        $in.val(max);
      } else if (inputVal < min) {
        $in.val(min);
      } else if ((inputVal - min) % step != 0) {
        $in.val(inputVal - ((inputVal - min) % step));
      }
    }
  });
  $('body').on('click', '.input-number .input-group-btn-vertical .btn:first-of-type', function(e) {
    var $in = $(this).parents(".input-number:first").find("input[data-type='number']");
    var min = 10;
    var max = 10000;
    var step = 1;
    if ($in) {
      if ($in.data('min')) {
        min = parseInt($in.data('min'), 10);
      }
      if ($in.data('max')) {
        max = parseInt($in.data('max'), 10);
      }
      if ($in.data('step')) {
        step = parseInt($in.data('step'), 10);
      }
      var val = parseInt($in.val(), 10);
      if (val + step <= max)
        $in.val(val + step);
    }
  });
  $('body').on('click', '.input-number .input-group-btn-vertical .btn:last-of-type', function(e) {
    var $in = $(this).parents(".input-number:first").find("input[data-type='number']");
    var min = 10;
    var max = 10000;
    var step = 1;
    if ($in) {
      if ($in.data('min')) {
        min = parseInt($in.data('min'), 10);
      }
      if ($in.data('max')) {
        max = parseInt($in.data('max'), 10);
      }
      if ($in.data('step')) {
        step = parseInt($in.data('step'), 10);
      }
      var val = parseInt($in.val(), 10);
      if (val - step >= min)
        $in.val(val - step);
    }
  });
}(jQuery));

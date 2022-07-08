


$(document).ready(() => {

    $('input[name="daterange"]').daterangepicker({
        opens: 'left',
    }, function(start, end, label) {
        console.log("A new date selection was made: " + start.format("YYYY-MM-DD") +" to "+ end.format("YYYY-MM-DD"))
    }
    );

    /*
        날짜는 선택이 안되고 
        분기별로만 선택이 되도록 한다. 
        날짜 선택을 해도 분기로 데이터가 나오도록 한다.

        변경할 부분이 많아 보인다.

        sk ens 것을 참조한다.
    */

    const st_dt = moment().subtract(29, 'days');
	const en_dt = moment();
    
    console.log(`st_dt = ${st_dt.format("YYYY-MM-DD")} , en_dt = ${en_dt.format("YYYY-MM-DD")}`);

    $("#reportrange").daterangepicker({
        startDate: st_dt,
        endData: en_dt,
        expanded: true,
        ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        }
    },cb);

    cb(st_dt, en_dt);

});

function cb(start , end) {
    console.log('cd');
    $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
}

//  Date Range Picker


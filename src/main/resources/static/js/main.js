
var hotelsApi = Vue.resource('/hotels/{id}');

Vue.component('hotel-row', {
    props: ['hotel'],
    template: '<div><i>({{ hotel.name }})</i> {{ hotel.pricePerNight }}</div>'
});

Vue.component('hotels-list', {
    props: ['hotels'],
    template:
        '<div>'+
            '<hotel-row v-for="hotel in hotels" :key="hotel.id" :hotel="hotel" />' +
        '</div>',
    created: function () {
        hotelsApi.get().then(result=>
            result.json().then(data =>
                data.forEach(hotel => this.hotels.push(hotel))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<hotels-list :hotels="hotels"/>',
    data: {
        hotels: [

        ]
    }
});
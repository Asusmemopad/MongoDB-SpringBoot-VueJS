
var hotelsApi = Vue.resource('/hotels/{id}');

Vue.component('hotel-form', {
    props:['hotels'],
    data: function () {
        return {
            name: '',
            pricePerNight:''
        }
    },
    template:
        '<div>'+
            '<input type="text" placeholder="Write name hotel" v-model="name"/>'+'</br>'+
            '<input type="text" placeholder="Write price" v-model="pricePerNight"/>'+'</br>'+
            '<input type="button" value="Save" @click="save"/>'+
        '</div>',
    methods: {
        save: function () {
            var hotel = {
                name: this.name,
                pricePerNight: this.pricePerNight
            }

            hotelsApi.save({}, hotel).then(result =>
                result.json().then(data => {
                    this.hotels.push(data)
                    this.name = ''
                    this.pricePerNight = ''
                })
            )
        }
    }
});

Vue.component('hotel-row', {
    props: ['hotel'],
    template: '<div><i>({{ hotel.name }})</i> {{ hotel.pricePerNight }}</div>'
});

Vue.component('hotels-list', {
    props: ['hotels'],
    template:
        '<div>'+
            '<hotel-form :hotels="hotels"/>'+
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
        hotels: []
    }
});
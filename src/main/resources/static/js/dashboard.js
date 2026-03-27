document.addEventListener("DOMContentLoaded", function () {

    const statusCtx = document.getElementById('statusChart');
    const listingCtx = document.getElementById('listingChart');

    if (statusCtx) {
        new Chart(statusCtx, {
            type: 'bar',
            data: {
                labels: ['AKTİF', 'KİRALANDI', 'SATILDI', 'PASİF'],
                datasets: [{
                    label: 'Emlak Sayısı',
                    data: window.statusData
                }]
            },
            options: {
                responsive: true
            }
        });
    }

    if (listingCtx) {
        new Chart(listingCtx, {
            type: 'pie',
            data: {
                labels: ['KİRALIK', 'SATILIK'],
                datasets: [{
                    label: 'İlan Türü',
                    data: window.listingData
                }]
            },
            options: {
                responsive: true
            }
        });
    }

});
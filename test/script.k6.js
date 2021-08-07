import http from 'k6/http';

export let options = {
  vus: 1000,
  duration: '60s',
};

export default function () {
  const payload = {
    customer: {
      id: null
    },
    status: 'PENDING_PAYMENT',
    amount: 50,
    items: [
      {
        product: {
          id: 1
        },
        unitValue: 30,
        quantity: 3
      },
      {
        product: {
          id: 2
        },
        unitValue: 20,
        quantity: 2
      }
    ]
  };

  for (let customer_id = 1; customer_id <= 1000; customer_id++) {
    payload.customer.id = customer_id;

    http.batch([
      [
        'POST',
        'http://localhost:3333/orders',
        JSON.stringify(payload),
        {
          headers: { 'Content-Type': 'application/json' },
          tags: { name: 'PostOrdersUrl' }
        }
      ],
    ]);
  }
}
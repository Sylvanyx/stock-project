import { CommonModule } from '@angular/common';
import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-stock-list',
  imports: [CommonModule],
  templateUrl: './stock-list.html',
  styleUrl: './stock-list.css'
})
export class StockList {

  stocks=[
    {"ticker":"MSFT","name":"Microsoft"},
    {"ticker":"Apple","name":"APLE"},
    {"ticker":"SPY","name":"SP 500"}
  ];

  selectedStock = signal<any>(null); // Track selected stock


  onStockSelect(stock: any) {
    this.selectedStock.set(stock);
    console.log('Selected stock:', stock);
  }


}

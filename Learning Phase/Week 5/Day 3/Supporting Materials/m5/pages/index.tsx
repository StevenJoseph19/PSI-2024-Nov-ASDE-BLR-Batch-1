import Head from 'next/head'
import styles from '@/pages/index.module.css'
import FilterList from '../components/FilterList'
import {useState} from 'react'
import LazyLabel from '@/components/LazyContent'

const listOfMetals = ["Lithium","Beryllium", "Sodium", "Magnesium", "Aluminium","Potassium", "Calcium","Scandium", "Titanium", "Vanadium","Chromium"]

export default function Home() {
  const [filter, setFilter] = useState("");
  const [selectedItems, setSelectedItems] = useState<string[]>([]);

  function handleItemSelection(itemSelected: string) {
    if (selectedItems.includes(itemSelected)) {
      setSelectedItems(selectedItems.filter(i => i != itemSelected));
    } else {
      setSelectedItems([itemSelected, ...selectedItems]);
    }
  }

  return (
    <div className={styles.container}>
      <Head>
        <title>Create Next App</title>
        <meta name="description" content="Generated by create next app" />
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <h1 className={styles.title}>
          Filter List
        </h1>
        <div>
          <FilterList items={listOfMetals} filter={filter} selectedItems={selectedItems} onFilterChange={setFilter} onItemSelection={handleItemSelection} />
        </div>
        <p>
          The <code>FilterList</code> component supports selecting list items, and filtering the list. 
        </p>
        <div style={{marginTop: "200px"}}>
          <LazyLabel delay={1000}>Some lazy-loaded content</LazyLabel>
        </div>
      </main>
      
      <footer className={styles.footer}>
        
      </footer>
    </div>
  )
}
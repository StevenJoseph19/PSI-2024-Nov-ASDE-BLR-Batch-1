import renderer from 'react-test-renderer';
import FilterList from '../components/FilterList';
import { planets, defaultProps } from './FilterList.rendering.test';

test('snapshot a date', () => {
  const favoriteDate = new Date(Date.UTC(2000, 0, 1));
  expect(favoriteDate.toISOString()).toMatchInlineSnapshot(
    `"2000-01-01T00:00:00.000Z"`
  );
});

test('snapshot a date (external)', () => {
  const favoriteDate = new Date(Date.UTC(2000, 0, 1));
  expect(favoriteDate.toISOString()).toMatchSnapshot();
});

test('snapshot a React component', () => {
  const tree = renderer
    .create(<FilterList items={planets} {...defaultProps} />)
    .toJSON();
  expect(tree).toMatchInlineSnapshot();
});
